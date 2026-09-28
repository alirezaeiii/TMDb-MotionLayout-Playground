package com.sample.android.tmdb.di

import android.app.Application
import com.sample.android.tmdb.util.NetworkUtils
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppUtilsModule {

    @Provides
    fun provideNetworkUtils(application: Application): NetworkUtils {
        return NetworkUtils(application)
    }
}