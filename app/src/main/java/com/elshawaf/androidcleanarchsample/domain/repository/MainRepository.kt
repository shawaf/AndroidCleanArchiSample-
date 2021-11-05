package com.elshawaf.androidcleanarchsample.domain.repository

import com.elshawaf.androidcleanarchsample.domain.model.AuthorModel
import com.elshawaf.androidcleanarchsample.domain.model.CommentModel
import com.elshawaf.androidcleanarchsample.domain.model.PostModel
import com.elshawaf.networking.Resource
import kotlinx.coroutines.flow.Flow

interface MainRepository {

    fun getAuthorsList() : Flow<Resource<List<AuthorModel>>>
    fun getAuthorPosts(authorId:String) : Flow<Resource<List<PostModel>>>
    fun getPostComments(postID:String) : Flow<Resource<List<CommentModel>>>

}