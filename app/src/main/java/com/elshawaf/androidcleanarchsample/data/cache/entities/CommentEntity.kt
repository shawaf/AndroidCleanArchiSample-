package com.elshawaf.androidcleanarchsample.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import java.io.Serializable


@Entity(tableName = DBConst.CommentsTableName)
data class CommentEntity(
    val date: String? = null,
    val avatarUrl: String? = null,
    @PrimaryKey
    val id: Int? = null,
    val postId: Int? = null,
    val body: String? = null,
    val userName: String? = null,
    val email: String? = null
) : Serializable

