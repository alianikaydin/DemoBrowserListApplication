package com.example.demoapplication.features.chart.di

import androidx.lifecycle.ViewModel
import com.example.core.di.scope.FragmentScoped
import com.example.core.di.scope.ViewModelKey
import com.example.demoapplication.features.chart.ChartFragment
import com.example.demoapplication.features.chart.ChartViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class ChartFeatureModule {

    @Binds
    @IntoMap
    @ViewModelKey(ChartViewModel::class)
    internal abstract fun provideChartViewModel(chartViewModel: ChartViewModel): ViewModel

    @FragmentScoped
    @ContributesAndroidInjector()
    abstract fun contributeChartFragment(): ChartFragment
}