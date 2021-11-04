package com.elshawaf.androidcleanarchsample.data.remote.dto

import com.google.gson.annotations.SerializedName


data class PostDTO(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("imageUrl")
	val imageUrl: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("authorId")
	val authorId: Int? = null
)
