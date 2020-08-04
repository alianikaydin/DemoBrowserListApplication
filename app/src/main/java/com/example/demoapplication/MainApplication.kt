package com.example.demoapplication

import android.app.Application
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import com.example.demoapplication.di.component.BaseAppComponent
import com.example.demoapplication.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : Application(),
    HasSupportFragmentInjector, HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()
        createAppComponent().inject(this)
    }

    public override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentInjector
    }

    @NonNull
    protected fun createAppComponent(): BaseAppComponent {
        return DaggerAppComponent.builder()
            .application(this)
            //.database(AppDatabase.getInstance(this)!!)
            .build()
    }
}