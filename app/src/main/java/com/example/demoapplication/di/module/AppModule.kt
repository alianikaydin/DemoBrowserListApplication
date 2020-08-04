package com.example.demoapplication.di.module

import android.app.Application
import android.content.Context
import com.example.core.di.scope.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [AppModule.Binder::class])
class AppModule {
    @Provides
    @Singleton
    @ApplicationContext
    fun provideContext(application: Application): Context {
        return application
    }

    @Module
    internal interface Binder {

    }
}
