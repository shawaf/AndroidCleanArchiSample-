package com.elshawaf.networking.intereceptor

import okhttp3.logging.HttpLoggingInterceptor

/**
 * Created by Mohamed Elshawaf on 1/7/2021
 */
class LoggingInterceptor(
) : HttpLoggingInterceptor.Logger {

    override fun log(message: String) {
    }
}
