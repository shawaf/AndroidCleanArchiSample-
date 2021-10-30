package com.elshawaf.networking.intereceptor

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * Created by Mohamed Elshawaf on 1/7/2021
 */
interface LoggingProvider {

    fun log(message: String)
}
