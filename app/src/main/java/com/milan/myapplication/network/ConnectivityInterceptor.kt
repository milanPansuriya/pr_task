package com.milan.myapplication.network

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import java.io.IOException
import java.net.InetAddress

class ConnectivityInterceptor(private val mContext: Context) : Interceptor {

    private val isInternet: Boolean
        get() {
            if (isOnline(mContext)) {
                try {
                    val address: InetAddress = InetAddress.getByName("www.google.com")
                    return !address.equals("")
                } catch (e: IOException) {
                    e.printStackTrace()
                }

            }
            return false
        }

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        if (!isInternet) {
            throw NoConnectivityException()
        }

        val builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    fun isOnline(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo != null && netInfo.isConnected
    }
}