package com.elshawaf.core.extension

import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * The ViewModelStoreOwner controls the scope of the ViewModel.
 * It may be overridden with a different ViewModelStoreOwner,
 * such as the host Activity or the parent fragment, in order to
 * scope the lifetime of the ViewModel to the lifetime of the
 * ViewModelStoreOwner that is passed in.
 * Created by Mohamed Elshawaf 13/7/2021.
 */
//inline fun <reified T : ViewModel> Fragment.viewModelWithProvider(
//    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
//    crossinline provider: () -> T
//) = viewModels<T>(ownerProducer) {
//    object : ViewModelProvider.Factory {
//        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//            @Suppress("UNCHECKED_CAST")
//            return provider.invoke() as T
//        }
//    }
//}
