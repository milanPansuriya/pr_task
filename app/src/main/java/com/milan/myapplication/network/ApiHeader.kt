package com.milan.myapplication.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

class ApiHeader @Inject constructor(internal val protectedApiHeader: ProtectedApiHeader) {


    class ProtectedApiHeader @Inject constructor(
        @Expose
        @SerializedName("Authorization") val accessToken: String?,
        @Expose
        @SerializedName("Accept") val Accept: String?
    )

}