package com.elshawaf.androidcleanarchsample.di

import android.content.Context
import com.elshawaf.androidcleanarchsample.data.cache.LocalDataSource
import com.elshawaf.androidcleanarchsample.data.cache.LocaleDataSourceImp
import com.elshawaf.androidcleanarchsample.data.cache.db.AppDatabase
import com.elshawaf.androidcleanarchsample.data.remote.RemoteApiServices
import com.elshawaf.androidcleanarchsample.data.remote.RemoteDataSource
import com.elshawaf.androidcleanarchsample.data.remote.RemoteDataSourceImp
import com.elshawaf.androidcleanarchsample.data.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit): RemoteApiServices = retrofit.create(RemoteApiServices::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(remoteApiServices: RemoteApiServices): RemoteDataSource = RemoteDataSourceImp(remoteApiServices)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideLocaleDataSource(appDatabase: AppDatabase): LocalDataSource = LocaleDataSourceImp(appDatabase)



    @Singleton
    @Provides
    fun provideMainRepository(localDataSource: LocalDataSource,remoteDataSource: RemoteDataSource) = MainRepository(remoteDataSource,localDataSource)

}