package com.example.core.base.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.example.core.base.utils.BackButtonHandler


abstract class BaseNavigatorActivity : BaseActivity() {

    abstract fun getNavigationResource(): Int

    abstract fun getNavGraphId(): Int

    abstract fun getFragmentContainerId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initNavigation()
    }

    private fun initNavigation() {
        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(getFragmentContainerId()) as NavHostFragment?
                ?: return
        val navController = host.navController
        val graph = navController.navInflater.inflate(getNavigationResource())
        navController.graph = graph
    }

    override fun onBackPressed() {
        supportFragmentManager.getCurrentNavigationFragment()?.let {
            if (it is BackButtonHandler) {
                if(it.doNothingWithBackButton()){
                    return
                }

                if (it.finishActivityWithBackButton()) {
                    finish()
                    return
                }

                val navOptions = NavOptions
                    .Builder()
                    .setPopUpTo(getNavGraphId(), true)
                    .build()

                NavHostFragment.findNavController(it).navigate(it.navigateToFragmentWithBackButton(),
                    null, navOptions)
                return
            }
        }
        super.onBackPressed()
    }

    private fun FragmentManager.getCurrentNavigationFragment(): Fragment? =
        primaryNavigationFragment?.childFragmentManager?.fragments?.first()
}