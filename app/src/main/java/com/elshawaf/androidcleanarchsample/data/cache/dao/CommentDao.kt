package com.elshawaf.androidcleanarchsample.data.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {

    @Query("SELECT * FROM ${DBConst.CommentsTableName}")
    fun getAllComments() : Flow<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(comments: List<CommentEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(comment: CommentEntity)

    @Query("DELETE FROM ${DBConst.CommentsTableName} WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM ${DBConst.CommentsTableName}")
    suspend fun deleteAllComments()


}