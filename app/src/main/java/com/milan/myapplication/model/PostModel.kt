package com.milan.myapplication.model

data class PostModel(
    val id: Int,
    val userName: String, val userAvatar: String, val postDate: String,
    val postImage: String, val heartCount: String, val commentCount: String, val shareCount: String,
    val isLike: Boolean
)