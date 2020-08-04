package com.example.core.base.dialog.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serializable

class YesNoDialogModel(
    @param:DrawableRes @field:DrawableRes var icon: Int,
    @param:StringRes @field:StringRes var title: Int,
    @param:StringRes @field:StringRes var message: Int,
    @param:StringRes @field:StringRes var negativeButtonName: Int,
    @param:StringRes @field:StringRes var positiveButtonName: Int
) : Serializable {
    constructor(icon: Int,
                message: Int,
                negativeButtonName: Int,
                positiveButtonName: Int) : this(icon, -1, message, negativeButtonName, positiveButtonName)

}