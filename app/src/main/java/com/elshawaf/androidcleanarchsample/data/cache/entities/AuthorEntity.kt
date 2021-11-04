package com.elshawaf.androidcleanarchsample.data.cache.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import java.io.Serializable

@Entity(tableName = DBConst.AuthorsTableName)
data class AuthorEntity(
    val avatarUrl: String? = null,
    val name: String? = null,
    @PrimaryKey
    val id: Int? = null,
    val userName: String? = null,
    val email: String? = null
): Serializable