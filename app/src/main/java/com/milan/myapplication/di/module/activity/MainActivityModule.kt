package com.milan.myapplication.di.module.activity

import com.milan.myapplication.ui.main.interector.MainInteractor
import com.milan.myapplication.ui.main.interector.MainMVPInteractor
import com.milan.myapplication.ui.main.presenter.MainMVPPresenter
import com.milan.myapplication.ui.main.presenter.MainPresenter
import com.milan.myapplication.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(interactor: MainInteractor): MainMVPInteractor =
        interactor

    @Provides
    internal fun provideMainPresenter(presenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = presenter
}