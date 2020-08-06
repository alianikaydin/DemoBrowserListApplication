package com.example.demoapplication.di.module

import com.example.demoapplication.features.list.di.ListContributesModule
import dagger.Module


@Module(includes = [ListContributesModule::class])
internal interface ContributeModule