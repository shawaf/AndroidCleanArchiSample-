package com.elshawaf.androidcleanarchsample.data.repository

import com.elshawaf.androidcleanarchsample.data.cache.LocalDataSource
import com.elshawaf.androidcleanarchsample.data.cache.entities.mapper.CacheMapper
import com.elshawaf.androidcleanarchsample.data.remote.RemoteDataSource
import com.elshawaf.androidcleanarchsample.data.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {


    fun getAuthorsList() = networkBoundResource(
        query = {
            localDataSource.getAllAuthors()
        },
        fetch = {
            delay(2000)
            remoteDataSource.getAllAuthorsAPI()
        },
        saveFetchResult = { authors ->
           localDataSource.insertAuthorsList(CacheMapper.toAuthorEntityList(authors))
        }
    )


    fun getAuthorPosts(authorId:String) = networkBoundResource(
        query = {
            localDataSource.getAuthorsPosts(authorId)
        },
        fetch = {
            delay(2000)
            remoteDataSource.getAuthorPostsAPI(authorId)
        },
        saveFetchResult = { posts ->
            localDataSource.insertPostsList(CacheMapper.toPostEntityList(posts))
        }
    )


    fun getPostComments(postID:String) = networkBoundResource(
        query = {
            localDataSource.getPostComments(postID)
        },
        fetch = {
            delay(2000)
            remoteDataSource.getPostCommentsAPI(postID)
        },
        saveFetchResult = { comments ->
            localDataSource.insertCommentsList(CacheMapper.toCommentEntityList(comments))
        }
    )
}