package com.elshawaf.androidcleanarchsample.presentation.authors_posts_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elshawaf.androidcleanarchsample.domain.usecases.GetAuthorPostsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorPostsListViewModel @Inject constructor(val getAuthorPostsListUseCase: GetAuthorPostsListUseCase) :ViewModel(){


    fun getAuthorPostsList(authorID:String) = getAuthorPostsListUseCase.getPosts(authorID).asLiveData()

}