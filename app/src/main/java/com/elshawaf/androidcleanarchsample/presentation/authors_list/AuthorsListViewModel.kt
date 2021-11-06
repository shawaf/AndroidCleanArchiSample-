package com.elshawaf.androidcleanarchsample.presentation.authors_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.elshawaf.androidcleanarchsample.domain.usecases.GetAuthorsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class AuthorsListViewModel @Inject constructor(val getAuthorsListUseCase: GetAuthorsListUseCase) : ViewModel(){


    var authorsList = getAuthorsListUseCase.getAuthorsList().asLiveData()
}