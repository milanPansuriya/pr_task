package com.milan.myapplication.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ApplicationModule(app: Application) {
    private lateinit var mApplication: Application

    init {
        mApplication = app
    }


    @Provides
    internal fun provideApplication(): Application {
        return mApplication
    }

    @ApplicationContext
    internal fun getContext(): Context {
        return mApplication.applicationContext
    }
}