package com.elshawaf.androidcleanarchsample.data.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.elshawaf.androidcleanarchsample.data.cache.dao.AuthorDao
import com.elshawaf.androidcleanarchsample.data.cache.dao.CommentDao
import com.elshawaf.androidcleanarchsample.data.cache.dao.PostDao
import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity


@Database(entities = [AuthorEntity::class , PostEntity::class , CommentEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun authorDao(): AuthorDao
    abstract fun postDao(): PostDao
    abstract fun commentDao(): CommentDao

    companion object {
        @Volatile private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, AppDatabase::class.java, DBConst.DBName)
                .fallbackToDestructiveMigration()
                .build()
    }
}