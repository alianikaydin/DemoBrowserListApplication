package com.example.core.base.fragment

import androidx.databinding.ViewDataBinding
import com.example.core.di.DaggerViewModelFactory
import javax.inject.Inject

abstract class BaseBindingDaggerViewModelFragment<T : ViewDataBinding> : BaseBindingDaggerFragment<T>() {

    @Inject
    protected lateinit var viewModelFactory: DaggerViewModelFactory

}