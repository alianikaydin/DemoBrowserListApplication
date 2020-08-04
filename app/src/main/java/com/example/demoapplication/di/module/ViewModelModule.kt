package com.example.demoapplication.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.core.di.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}