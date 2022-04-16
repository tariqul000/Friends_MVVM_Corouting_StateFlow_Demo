package com.tariqul.friendsdemoproject.di

import com.tariqul.friendsdemoproject.apiCall.UsersRemoteDataSource
import com.tariqul.friendsdemoproject.data.repository.UsersDefaultRepository
import com.tariqul.friendsdemoproject.data.repository.UsersRepository
import com.tariqul.friendsdemoproject.util.DispatcherProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providerHomeRepository(
        userRemoteDataSource: UsersRemoteDataSource,
        dispatcherProvider: DispatcherProvider
    ) : UsersRepository {
        return UsersDefaultRepository(
            userRemoteDataSource,
            dispatcherProvider
        )
    }
}