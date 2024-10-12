package com.vkr.simpleloginbywaqar.network

import android.content.Context
import androidx.lifecycle.ViewModel
import com.vkr.simpleloginbywaqar.ui.dashboard.DashboardVM
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideDataApi(
        @ApplicationContext context: Context,
        remoteDataSource: RemoteDataSource
    ): ApiService {
        return remoteDataSource.buildApi(ApiService::class.java, context)
    }
}