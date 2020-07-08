package com.milan.myapplication.ui.main.presenter

import com.milan.myapplication.base.MVPPresenter
import com.milan.myapplication.ui.main.interector.MainMVPInteractor
import com.milan.myapplication.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> :
    MVPPresenter<V, I> {

    fun getPostList()
}