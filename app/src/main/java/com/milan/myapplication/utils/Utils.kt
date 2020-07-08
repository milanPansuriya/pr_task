package com.milan.myapplication.utils

import com.androidnetworking.error.ANError
import org.json.JSONObject

object Utils {

    fun getErrorMessage(error: Throwable): String {
        if (error is ANError) {
            val anError = error as ANError
            if (anError.errorCode != 0) {
                return JSONObject(anError.errorBody).optString("msg")
            } else {
                return anError.errorDetail
            }
        } else {
            return error.message.toString()
        }
    }
}