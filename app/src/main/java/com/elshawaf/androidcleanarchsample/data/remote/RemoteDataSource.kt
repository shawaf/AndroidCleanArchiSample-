package com.elshawaf.androidcleanarchsample.data.remote

import com.elshawaf.androidcleanarchsample.data.remote.dto.AuthorDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.CommentDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.PostDTO
import retrofit2.Response

interface RemoteDataSource{

    suspend fun getAllAuthorsAPI(): List<AuthorDTO>
    suspend fun getAuthorPostsAPI(authorId: String): List<PostDTO>
    suspend fun getPostCommentsAPI(postID: String): List<CommentDTO>
}