package com.milan.myapplication.network

import android.content.Context
import com.androidnetworking.common.Priority
import com.milan.myapplication.ui.main.model.PostRespo
import com.rx2androidnetworking.Rx2AndroidNetworking
import okhttp3.OkHttpClient
import javax.inject.Inject

class AppApiHelper @Inject constructor(
    private val apiHeader: ApiHeader,
    private var mContext: Context
) : ApiHelper {

    val okHttpClient = OkHttpClient().newBuilder().addInterceptor(
        ConnectivityInterceptor(mContext)
    ).build()

    override fun getPostList() = Rx2AndroidNetworking.post(AppUrls.POST_LIST)
        .setPriority(Priority.IMMEDIATE)
        .setOkHttpClient(okHttpClient)
        .build()
        .getObjectObservable(PostRespo::class.java)

}