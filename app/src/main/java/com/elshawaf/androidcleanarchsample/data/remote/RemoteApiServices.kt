package com.elshawaf.androidcleanarchsample.data.remote

import com.elshawaf.androidcleanarchsample.data.remote.dto.AuthorDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.CommentDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.PostDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteApiServices {

    @GET("authors")
    suspend fun getAllAuthors(): List<AuthorDTO>

    @GET("posts")
    suspend fun getAuthorPosts(@Query("authorId") id: String?): List<PostDTO>

    @GET("/posts/{id}/comments")
    suspend fun getPostComments(@Query("id") id: String?): List<CommentDTO>
}