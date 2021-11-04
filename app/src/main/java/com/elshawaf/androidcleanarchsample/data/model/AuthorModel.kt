package com.elshawaf.androidcleanarchsample.data.model

import kotlinx.serialization.Serializable


@Serializable
data class AuthorModel(
    val avatarUrl: String? = null,
    val name: String? = null,
    val id: Int? = null,
    val userName: String? = null,
    val email: String? = null
)