package com.example.demoapplication.di.component

import android.app.Application
import com.example.demoapplication.MainApplication
import dagger.BindsInstance

public interface BaseAppComponent {

    fun inject(application: MainApplication)

    interface Builder<C : BaseAppComponent, B : Builder<C, B>> {

        @BindsInstance
        fun application(application: Application): B

        /* @BindsInstance
         abstract fun database(roomDatabase: AppDatabase): B*/

        fun build(): C
    }
}
