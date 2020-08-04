package com.example.core.base.dialog.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.io.Serializable

class InfoDialogModel(
    @param:DrawableRes @field:DrawableRes var icon: Int,
    @param:StringRes @field:StringRes var title: Int,
    @param:StringRes @field:StringRes var description: Int
) : Serializable {
    constructor(description: Int) : this(-1, -1, description)
}