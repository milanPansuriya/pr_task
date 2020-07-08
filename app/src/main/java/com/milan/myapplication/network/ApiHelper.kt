package com.milan.myapplication.network

import com.milan.myapplication.ui.main.model.PostRespo
import io.reactivex.Observable

interface ApiHelper {

    fun getPostList(): Observable<PostRespo>
}