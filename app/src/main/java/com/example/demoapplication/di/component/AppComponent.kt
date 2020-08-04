package com.example.demoapplication.di.component

import com.example.demoapplication.di.module.AppModule
import com.example.demoapplication.di.module.ContributeModule
import com.example.demoapplication.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AppModule::class,
    ViewModelModule::class,
    //DatabaseModule::class,
    //NetworkModule::class,
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    ContributeModule ::class
])
@Singleton
interface AppComponent : BaseAppComponent {

    @Component.Builder
    interface Builder : BaseAppComponent.Builder<AppComponent, Builder>
}
