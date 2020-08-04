package com.example.core.base.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingActivity<T : ViewDataBinding> : BaseActivity() {
    override fun enableBinding() = true
    protected var binding: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (null == binding) {
            binding = DataBindingUtil.setContentView(this, getRootLayoutId())
        }

        binding?.lifecycleOwner = this
        binding?.executePendingBindings()
    }
}