package com.elshawaf.androidcleanarchsample.data.model

import kotlinx.serialization.Serializable


@Serializable
data class PostModel(
	val date: String? = null,
	val imageUrl: String? = null,
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val authorId: Int? = null
)

