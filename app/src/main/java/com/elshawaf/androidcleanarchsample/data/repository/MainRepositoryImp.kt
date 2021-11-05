package com.elshawaf.androidcleanarchsample.data.repository

import com.elshawaf.androidcleanarchsample.data.cache.LocalDataSource
import com.elshawaf.androidcleanarchsample.data.cache.entities.mapper.CacheMapper
import com.elshawaf.androidcleanarchsample.data.remote.RemoteDataSource
import com.elshawaf.androidcleanarchsample.data.util.networkBoundResource
import com.elshawaf.androidcleanarchsample.domain.model.mapper.DomainMapper
import com.elshawaf.androidcleanarchsample.domain.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MainRepositoryImp @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
):MainRepository {


    override fun getAuthorsList() = networkBoundResource(
        query = {
            localDataSource.getAllAuthors().map { list -> DomainMapper.toAuthorDomailList(list) }
        },
        fetch = {
            delay(2000)
            remoteDataSource.getAllAuthorsAPI()
        },
        saveFetchResult = { authors ->
           localDataSource.insertAuthorsList(CacheMapper.toAuthorEntityList(authors))
        }
    )


    override fun getAuthorPosts(authorId:String) = networkBoundResource(
        query = {
            localDataSource.getAuthorsPosts(authorId).map { list -> DomainMapper.toPostDomailList(list) }
        },
        fetch = {
            delay(2000)
            remoteDataSource.getAuthorPostsAPI(authorId)
        },
        saveFetchResult = { posts ->
            localDataSource.insertPostsList(CacheMapper.toPostEntityList(posts))
        }
    )


    override fun getPostComments(postID:String) = networkBoundResource(
        query = {
            localDataSource.getPostComments(postID).map { list -> DomainMapper.toCommentDomailList(list) }
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