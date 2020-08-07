package com.example.demoapplication.di.module

import com.example.demoapplication.features.chart.di.ChartContributesModule
import com.example.demoapplication.features.list.di.ListContributesModule
import dagger.Module


@Module(includes = [ListContributesModule::class, ChartContributesModule::class])
internal interface ContributeModule