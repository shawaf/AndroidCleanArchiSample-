package com.elshawaf.androidcleanarchsample.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class PostModel(
	val date: String? = null,
	val imageUrl: String? = null,
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val authorId: Int? = null
):Parcelable

