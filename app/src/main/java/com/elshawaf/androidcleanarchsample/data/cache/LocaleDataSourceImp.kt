package com.elshawaf.androidcleanarchsample.data.cache

import androidx.room.withTransaction
import com.elshawaf.androidcleanarchsample.data.cache.db.AppDatabase
import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocaleDataSourceImp @Inject constructor(
    var appDatabase: AppDatabase
) : LocalDataSource {


    /**
     * Authors Database Operations
     */
    override fun getAllAuthors() = appDatabase.authorDao().getAllAuthors()

    override suspend fun insertAuthorsList(authorsEntityList: List<AuthorEntity>) {
        appDatabase.withTransaction {
            appDatabase.authorDao().deleteAllAuthors()
            appDatabase.authorDao().insertAll(authorsEntityList)
        }
    }

    /**
     * Posts Database Operations
     */
    override fun getAuthorsPosts(authorID: String) = appDatabase.postDao().getAllPosts(authorID.toInt())

    override suspend fun insertPostsList(postsEntityList: List<PostEntity>) {
        appDatabase.withTransaction {
            appDatabase.postDao().deleteAllPosts()
            appDatabase.postDao().insertAll(postsEntityList)
        }
    }

    /**
     * Comments Database Operations
     */
    override fun getPostComments(postID: String) = appDatabase.commentDao().getAllComments()

    override suspend fun insertCommentsList(commentsEntityList: List<CommentEntity>) {
        appDatabase.withTransaction {
            appDatabase.commentDao().deleteAllComments()
            appDatabase.commentDao().insertAll(commentsEntityList)
        }
    }
}