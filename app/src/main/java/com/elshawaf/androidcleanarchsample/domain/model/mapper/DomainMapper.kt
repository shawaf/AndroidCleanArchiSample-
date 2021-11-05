package com.elshawaf.androidcleanarchsample.domain.model.mapper

import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity
import com.elshawaf.androidcleanarchsample.domain.model.AuthorModel
import com.elshawaf.androidcleanarchsample.domain.model.CommentModel
import com.elshawaf.androidcleanarchsample.domain.model.PostModel

object DomainMapper {

    /**
     *  Single Mappers
     */

    fun mapToAuthorModel(input: AuthorEntity): AuthorModel {
        return AuthorModel(
            avatarUrl = input.avatarUrl,
            name = input.name,
            id = input.id,
            userName = input.userName,
            email = input.email
        )
    }

    fun mapToPostModel(input: PostEntity): PostModel {
        return PostModel(
            date = input.date,
            imageUrl = input.imageUrl,
            id = input.id,
            title = input.title,
            body = input.body,
            authorId = input.authorId
        )
    }


    fun mapToCommentModel(input: CommentEntity): CommentModel {
        return CommentModel(
            date=input.date,
            avatarUrl = input.avatarUrl,
            id=input.id,
            postId = input.postId,
            body = input.body,
            userName = input.userName,
            email = input.email
        )
    }

    /**
     *  List Mappers
     */

    fun toAuthorDomailList(authorsEntitiesList: List<AuthorEntity>): List<AuthorModel> {
        val domainModelList: ArrayList<AuthorModel> = ArrayList()
        for (author in authorsEntitiesList) {
            domainModelList.add(mapToAuthorModel(author))
        }
        return domainModelList
    }


    fun toPostDomailList(postsEntitiesList: List<PostEntity>): List<PostModel> {
        val domainModelList: ArrayList<PostModel> = ArrayList()
        for (entity in postsEntitiesList) {
            domainModelList.add(mapToPostModel(entity))
        }
        return domainModelList
    }


    fun toCommentDomailList(commentsEntitiesList: List<CommentEntity>): List<CommentModel> {
        val domainModelList: ArrayList<CommentModel> = ArrayList()
        for (entity in commentsEntitiesList) {
            domainModelList.add(mapToCommentModel(entity))
        }
        return domainModelList
    }


}