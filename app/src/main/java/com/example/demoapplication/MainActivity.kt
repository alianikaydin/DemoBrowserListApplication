package com.example.demoapplication

import com.example.core.base.activity.BaseNavigatorActivity

class MainActivity : BaseNavigatorActivity() {
    override fun getFragmentContainerId(): Int = R.id.fragment_container
    override fun getNavGraphId(): Int = R.id.main_navigation
    override fun getNavigationResource(): Int = R.navigation.main_navigation
    override fun getRootLayoutId(): Int = R.layout.activity_main
}