package com.example.core.base.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseBindingFragment<T : ViewDataBinding> : BaseFragment() {

    abstract fun applyBinding(binding: T)

    protected var binding: T? = null
    private var isFirstViewCreation = false

    //region Fragment
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (null == binding) {
            isFirstViewCreation = true
            binding = DataBindingUtil.inflate(inflater, getRootLayoutId(), container, false)
        } else {
            isFirstViewCreation = false
        }
        return binding!!.apply {
            lifecycleOwner = this@BaseBindingFragment
            applyBinding(this)
            executePendingBindings()
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (isFirstViewCreation) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                view.requestApplyInsets()
            } else {
                view.requestFitSystemWindows()
            }
            initView(view)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}