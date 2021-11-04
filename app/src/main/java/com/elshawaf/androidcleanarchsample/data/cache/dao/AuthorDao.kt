package com.elshawaf.androidcleanarchsample.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.elshawaf.androidcleanarchsample.data.cache.db.DBConst
import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AuthorDao {

    @Query("SELECT * FROM ${DBConst.AuthorsTableName}")
    fun getAllAuthors() : Flow<List<AuthorEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(authors: List<AuthorEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(author: AuthorEntity)

    @Query("DELETE FROM ${DBConst.AuthorsTableName} WHERE id = :id")
    suspend fun delete(id: Int)

    @Query("DELETE FROM ${DBConst.AuthorsTableName}")
    suspend fun deleteAllAuthors()
}