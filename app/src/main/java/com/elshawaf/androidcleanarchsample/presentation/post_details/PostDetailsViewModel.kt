package com.elshawaf.androidcleanarchsample.presentation.post_details

import androidx.lifecycle.ViewModel
import com.elshawaf.androidcleanarchsample.domain.usecases.GetPostCommentsListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PostDetailsViewModel @Inject constructor(val postCommentsListUseCase: GetPostCommentsListUseCase) : ViewModel(){
}