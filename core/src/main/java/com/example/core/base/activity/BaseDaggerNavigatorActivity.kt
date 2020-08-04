package com.example.core.base.activity

abstract class BaseDaggerNavigatorActivity : BaseNavigatorActivity() {

    override fun shouldInjectDagger() = true

}