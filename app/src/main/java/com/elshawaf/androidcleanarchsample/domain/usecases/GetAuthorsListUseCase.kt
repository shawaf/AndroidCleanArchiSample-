package com.elshawaf.androidcleanarchsample.domain.usecases

import androidx.lifecycle.ViewModel
import com.elshawaf.androidcleanarchsample.domain.repository.MainRepository
import javax.inject.Inject

class GetAuthorsListUseCase @Inject constructor(val mainRepository: MainRepository):ViewModel() {

    fun getAuthorsList() = mainRepository.getAuthorsList()


}