package com.milan.myapplication.ui.main.model

import com.google.gson.annotations.SerializedName

data class PostRespoItem(
    @SerializedName("create_dt")
    val createDt: String,
    @SerializedName("geo_lat")
    val geoLat: String,
    @SerializedName("geo_long")
    val geoLong: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("image")
    val image: String,
    @SerializedName("is_active")
    val isActive: String,
    @SerializedName("is_geo_constrain")
    val isGeoConstrain: String,
    @SerializedName("link")
    val link: String,
    @SerializedName("post_exposure")
    val postExposure: String,
    @SerializedName("post_text")
    val postText: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("trend")
    val trend: String,
    @SerializedName("user_id")
    val userId: String

)