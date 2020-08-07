package com.example.demoapplication.features

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.core.base.activity.BaseNavigatorActivity
import com.example.demoapplication.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : BaseNavigatorActivity() {
    override fun getFragmentContainerId(): Int = R.id.fragment_container
    override fun getNavGraphId(): Int = R.id.main_navigation
    override fun getNavigationResource(): Int = R.navigation.main_navigation
    override fun getRootLayoutId(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val host: NavHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_container) as NavHostFragment? ?: return

        val navController = host.navController
        setupBottomNavMenu(navController)
    }

    private fun setupBottomNavMenu(navController: NavController) {
        val bottomNav = findViewById<BottomNavigationView>(R.id.navigationView)
        bottomNav?.setupWithNavController(navController)
    }

}