package com.example.core.base.fragment

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment : Fragment() {

    @LayoutRes
    abstract fun getRootLayoutId(): Int

    abstract fun initView(rootView: View)

    private var rootView: View? = null
    private var isFirstViewCreation = false

    open fun shouldInjectFragment() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (shouldInjectFragment()) {
            AndroidSupportInjection.inject(this)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (null == rootView) {
            isFirstViewCreation = true
            rootView = inflater.inflate(getRootLayoutId(), container, false)
        } else {
            isFirstViewCreation = false
        }
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
        rootView = null
    }
}
