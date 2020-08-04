package com.example.core.base.fragment

import androidx.databinding.ViewDataBinding

abstract class BaseBindingDaggerFragment<T : ViewDataBinding> : BaseBindingFragment<T>() {

    override fun shouldInjectFragment() = true
}