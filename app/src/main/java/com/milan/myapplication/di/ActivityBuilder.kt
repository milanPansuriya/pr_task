package com.milan.myapplication.di

import com.milan.myapplication.di.module.activity.MainActivityModule
import com.milan.myapplication.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity
}