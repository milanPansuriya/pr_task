package com.milan.myapplication.di.module

import android.app.Application
import android.content.Context
import com.milan.myapplication.base.SchedulerProvider
import com.milan.myapplication.base.SharedPrefsHelper
import com.milan.myapplication.network.ApiHeader
import com.milan.myapplication.network.ApiHelper
import com.milan.myapplication.network.AppApiHelper
import com.milan.myapplication.utils.PrefConst
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application


    @Provides
    @Singleton
    internal fun provideProtectedApiHeader()
            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(
        accessToken = "Bearer " + SharedPrefsHelper[PrefConst.AUTH_TOKEN, ""],
        Accept = "application/json"
    )

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper


    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()


}