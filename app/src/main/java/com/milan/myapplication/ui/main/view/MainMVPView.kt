package com.milan.myapplication.ui.main.view

import com.milan.myapplication.base.MVPView
import com.milan.myapplication.ui.main.model.PostRespo

interface MainMVPView : MVPView {

    fun showValidationMessage(errorMessage: String?)

    fun setPostData(postRespo: PostRespo)
}