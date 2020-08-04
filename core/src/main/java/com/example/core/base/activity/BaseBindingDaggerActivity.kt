package com.example.core.base.activity

import androidx.databinding.ViewDataBinding

abstract class BaseBindingDaggerActivity<T : ViewDataBinding> : BaseBindingActivity<T>() {

    override fun shouldInjectDagger() = true

}