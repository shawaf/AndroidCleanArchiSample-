package com.elshawaf.networking.http

import com.elshawaf.networking.http.RetrofitFactory.createRetrofit
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Factory class to create [Retrofit] via [createRetrofit].
 * Created by Mohamed Elshawaf .
 */
object RetrofitFactory {

    fun createRetrofit(baseUrl: BaseUrl, okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl.url)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }
}
