package com.elshawaf.androidcleanarchsample.data.remote

import javax.inject.Inject

class RemoteDataSourceImp  @Inject constructor(val remoteApiServices:RemoteApiServices) :RemoteDataSource {

    override suspend fun getAllAuthorsAPI() = remoteApiServices.getAllAuthors()
    override suspend fun getAuthorPostsAPI(authorId: String) = remoteApiServices.getAuthorPosts(authorId)
    override suspend fun getPostCommentsAPI(postID: String) = remoteApiServices.getPostComments(postID)
}