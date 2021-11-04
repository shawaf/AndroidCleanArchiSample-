package com.elshawaf.androidcleanarchsample.data.cache.entities.mapper

import com.elshawaf.androidcleanarchsample.data.cache.entities.AuthorEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.CommentEntity
import com.elshawaf.androidcleanarchsample.data.cache.entities.PostEntity
import com.elshawaf.androidcleanarchsample.data.remote.dto.AuthorDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.CommentDTO
import com.elshawaf.androidcleanarchsample.data.remote.dto.PostDTO

object CacheMapper {

    /**
     *  Single Mappers
     */

    fun mapToAuthorEntity(input: AuthorDTO): AuthorEntity {
        return AuthorEntity(
            avatarUrl = input.avatarUrl,
            name = input.name,
            id = input.id,
            userName = input.userName,
            email = input.email
        )
    }

    fun mapToPostEntity(input: PostDTO): PostEntity {
        return PostEntity(
            date = input.date,
            imageUrl = input.imageUrl,
            id = input.id,
            title = input.title,
            body = input.body,
            authorId = input.authorId
        )
    }


    fun mapToCommentEntity(input: CommentDTO): CommentEntity {
        return CommentEntity(
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

    fun toAuthorEntityList(authorsDTOsList: List<AuthorDTO>): List<AuthorEntity> {
        val entities: ArrayList<AuthorEntity> = ArrayList()
        for (author in authorsDTOsList) {
            entities.add(mapToAuthorEntity(author))
        }
        return entities
    }


    fun toPostEntityList(postsDTOsList: List<PostDTO>): List<PostEntity> {
        val entities: ArrayList<PostEntity> = ArrayList()
        for (entity in postsDTOsList) {
            entities.add(mapToPostEntity(entity))
        }
        return entities
    }


    fun toCommentEntityList(commentsDTOsList: List<CommentDTO>): List<CommentEntity> {
        val entities: ArrayList<CommentEntity> = ArrayList()
        for (entity in commentsDTOsList) {
            entities.add(mapToCommentEntity(entity))
        }
        return entities
    }


}