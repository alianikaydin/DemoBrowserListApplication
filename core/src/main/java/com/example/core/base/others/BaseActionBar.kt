package com.example.core.base.others

import androidx.lifecycle.MutableLiveData

open class BaseActionBar {


    fun <T : Any?> MutableLiveData<T>.default(initialValue: T) = apply { setValue(initialValue) }
}