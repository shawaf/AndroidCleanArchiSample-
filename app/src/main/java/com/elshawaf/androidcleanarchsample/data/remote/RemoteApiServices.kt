package com.elshawaf.androidcleanarchsample.data.remote

import com.elshawaf.androidcleanarchsample.data.remote.dto.AuthorDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.CommentDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.PostDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteApiServices {

    @GET("authors")
    suspend fun getAllAuthors(): List<AuthorDTO>

    @GET("posts?authorId={id}")
    suspend fun getAuthorPosts(@Path("id") id: String?): List<PostDTO>

    @GET("/posts/{id}/comments")
    suspend fun getPostComments(@Path("id") id: String?): List<CommentDTO>
}