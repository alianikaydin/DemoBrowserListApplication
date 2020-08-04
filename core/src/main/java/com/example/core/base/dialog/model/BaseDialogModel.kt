package com.example.core.base.dialog.model

import androidx.annotation.StringRes
import java.io.Serializable

class BaseDialogModel(
    @param:StringRes @field:StringRes var title: Int,
    @param:StringRes @field:StringRes var message: Int
) : Serializable