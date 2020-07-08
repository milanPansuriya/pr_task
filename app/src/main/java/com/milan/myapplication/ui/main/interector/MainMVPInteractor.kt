package com.milan.myapplication.ui.main.interector

import com.milan.myapplication.base.MVPInteractor
import com.milan.myapplication.ui.main.model.PostRespo
import io.reactivex.Observable

interface MainMVPInteractor : MVPInteractor {

    fun getPostList(): Observable<PostRespo>
}