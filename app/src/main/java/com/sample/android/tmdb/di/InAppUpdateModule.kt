package com.sample.android.tmdb.di

import android.app.Activity
import com.sample.android.tmdb.ui.start.InAppUpdateHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class InAppUpdateModule {

    @Provides
    internal fun provideInAppUpdate(activity: Activity): InAppUpdateHandler =
        InAppUpdateHandler(activity)
}