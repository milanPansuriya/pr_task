package com.milan.myapplication.ui.main.interector

import com.milan.myapplication.base.BaseInteractor
import com.milan.myapplication.network.ApiHelper
import javax.inject.Inject

class MainInteractor @Inject internal constructor(apiHelper: ApiHelper) :
    BaseInteractor(apiHelper), MainMVPInteractor {

    override fun getPostList() = apiHelper.getPostList()
}