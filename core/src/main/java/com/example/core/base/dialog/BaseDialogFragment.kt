package com.example.core.base.dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core.base.dialog.item.DialogAction

abstract class BaseDialogFragment : DialogFragment() {
    @LayoutRes
    abstract fun getRootLayoutId(): Int

    protected abstract fun initView(savedInstanceState: Bundle)

    var mLiveData = MutableLiveData<DialogAction>()

    val dialogObserver: LiveData<DialogAction>
        get() = mLiveData

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(getRootLayoutId(), container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        return view
    }

    companion object {
        val MODEL_SAVED_INSTANCE = "MODEL_SAVED_INSTANCE"
    }
}