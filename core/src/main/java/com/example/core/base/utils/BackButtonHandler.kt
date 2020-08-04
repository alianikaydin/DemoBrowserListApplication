package com.example.core.base.utils

interface BackButtonHandler {

    fun finishActivityWithBackButton(): Boolean
    fun doNothingWithBackButton(): Boolean
    fun navigateToFragmentWithBackButton(): Int
}