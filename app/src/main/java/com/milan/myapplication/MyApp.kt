package com.milan.myapplication

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.milan.myapplication.base.SharedPrefsHelper
import com.milan.myapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MyApp : Application(), HasAndroidInjector{

    @Inject
    lateinit internal var mFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        SharedPrefsHelper.init(this)
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}