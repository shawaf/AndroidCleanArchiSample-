package com.elshawaf.androidcleanarchsample.domain.usecases

import androidx.lifecycle.ViewModel
import com.elshawaf.androidcleanarchsample.domain.repository.MainRepository
import javax.inject.Inject

class GetPostCommentsListUseCase @Inject constructor(val mainRepository: MainRepository) {

    fun getPostComments(postID:String) = mainRepository.getPostComments(postID)


}