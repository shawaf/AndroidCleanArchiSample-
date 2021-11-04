package com.elshawaf.androidcleanarchsample.data.remote.dto

import com.google.gson.annotations.SerializedName


data class CommentDTO(

	@field:SerializedName("date")
	val date: String? = null,

	@field:SerializedName("avatarUrl")
	val avatarUrl: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("postId")
	val postId: Int? = null,

	@field:SerializedName("body")
	val body: String? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
