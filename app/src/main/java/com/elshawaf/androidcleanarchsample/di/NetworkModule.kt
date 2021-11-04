package com.elshawaf.androidcleanarchsample.di

import com.elshawaf.androidcleanarchsample.BuildConfig
import com.elshawaf.core.util.BuildTypeProvider
import com.elshawaf.networking.http.BaseUrl
import com.elshawaf.networking.http.OkHttpClientFactory
import com.elshawaf.networking.http.RetrofitFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideBaseUrl() = BaseUrl(BuildConfig.BASE_URL)


    @Provides
    @Singleton
    fun provideGson(): Gson = GsonBuilder().create()



    @Provides
    @Singleton
    fun provideOkHttpClient(
        buildTypeProvider: BuildTypeProvider,
    ): OkHttpClient {
        return OkHttpClientFactory.createOkHttpClient(
            isDebug = buildTypeProvider.isDebugBuild(),
            sslSocket = null
        )
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: BaseUrl,
        okHttpClient: OkHttpClient,
        gson : Gson
    ): Retrofit {
        return RetrofitFactory.createRetrofit(
            baseUrl = baseUrl,
            okHttpClient = okHttpClient,
            gson = gson
        )
    }





}
