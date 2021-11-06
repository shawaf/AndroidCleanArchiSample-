package com.elshawaf.androidcleanarchsample.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

    @Query("SELECT * FROM ${DBConst.PostsTableName} WHERE authorId = :id")
    fun getAllPosts(id: Int) : Flow<List<PostEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(posts: List<PostEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(post: PostEntity)

    @Query("DELETE FROM ${DBConst.PostsTableName} WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM ${DBConst.PostsTableName}")
    suspend fun deleteAllPosts()
}