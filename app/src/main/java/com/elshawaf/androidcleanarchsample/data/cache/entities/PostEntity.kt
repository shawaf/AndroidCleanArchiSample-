package com.elshawaf.androidcleanarchsample.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import java.io.Serializable


@Entity(tableName = DBConst.PostsTableName)
data class PostEntity(
	val date: String? = null,
	val imageUrl: String? = null,
	@PrimaryKey
	val id: Int? = null,
	val title: String? = null,
	val body: String? = null,
	val authorId: Int? = null
): Serializable

