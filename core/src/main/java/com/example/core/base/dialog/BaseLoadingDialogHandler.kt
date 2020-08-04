package com.example.core.base.dialog

import androidx.lifecycle.LiveData

abstract class BaseLoadingDialogHandler {
    abstract fun triggerDialog()
    abstract fun dismiss()
    abstract fun getDialogObserver(): LiveData<Boolean>
}