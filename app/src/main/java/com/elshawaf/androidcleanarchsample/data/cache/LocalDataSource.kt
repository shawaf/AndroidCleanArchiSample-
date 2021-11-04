package com.elshawaf.androidcleanarchsample.data.cache

import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllAuthors(): Flow<List<AuthorEntity>>

    suspend fun insertAuthorsList(authorsEntityList: List<AuthorEntity>)

    fun getAuthorsPosts(authorID: String): Flow<List<PostEntity>>

    suspend fun insertPostsList(postsEntityList: List<PostEntity>)

    fun getPostComments(postID: String): Flow<List<CommentEntity>>

    suspend fun insertCommentsList(commentsEntityList: List<CommentEntity>)


}