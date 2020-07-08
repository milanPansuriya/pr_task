package com.milan.myapplication.base

import com.milan.myapplication.network.ApiHelper

open class BaseInteractor() : MVPInteractor {

    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }

    protected lateinit var apiHelper: ApiHelper


}