package com.elshawaf.androidcleanarchsample.data.remote.dto

import com.google.gson.annotations.SerializedName


data class AuthorDTO(

	@field:SerializedName("avatarUrl")
	val avatarUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("userName")
	val userName: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
