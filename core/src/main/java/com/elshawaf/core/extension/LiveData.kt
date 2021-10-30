package com.elshawaf.core.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Convert a [MutableLiveData] to its immutable version [LiveData].
 * Created by Mohamed Elshawaf on 12/7/2021
 */
fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>
