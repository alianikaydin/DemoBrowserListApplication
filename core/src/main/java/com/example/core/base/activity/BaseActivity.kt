package com.example.core.base.activity

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes
    abstract fun getRootLayoutId(): Int

    open fun hideAndroidActionBar() = false
    open fun shouldInjectDagger() = false
    open fun enableBinding() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (!enableBinding()) {
            setContentView(getRootLayoutId())
        }

        if (shouldInjectDagger()) {
            AndroidInjection.inject(this)
        }

        if (hideAndroidActionBar()) {
            supportActionBar?.hide()
        }
    }
}