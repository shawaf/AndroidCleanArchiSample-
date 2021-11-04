package com.elshawaf.androidcleanarchsample.data.model

import kotlinx.serialization.Serializable


@Serializable
data class CommentModel(
    val date: String? = null,
    val avatarUrl: String? = null,
    val id: Int? = null,
    val postId: Int? = null,
    val body: String? = null,
    val userName: String? = null,
    val email: String? = null
)

