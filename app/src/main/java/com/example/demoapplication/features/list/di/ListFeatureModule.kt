package com.example.demoapplication.features.list.di

import androidx.lifecycle.ViewModel
import com.example.core.di.scope.ActivityScoped
import com.example.core.di.scope.FragmentScoped
import com.example.core.di.scope.ViewModelKey
import com.example.demoapplication.features.MainActivity
import com.example.demoapplication.features.list.ListFragment
import com.example.demoapplication.features.list.ListFragmentViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ListFeatureModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListFragmentViewModel::class)
    internal abstract fun provideListFragmentViewModel(listFragmentViewModel: ListFragmentViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract fun contributeListFragment(): ListFragment

}
