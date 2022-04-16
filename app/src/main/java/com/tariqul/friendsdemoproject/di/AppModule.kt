package com.tariqul.friendsdemoproject.di

import com.tariqul.friendsdemoproject.apiCall.Apis
import com.tariqul.friendsdemoproject.util.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    private val okHttpClient = OkHttpClient.Builder().addInterceptor(loggingInterceptor).build()

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()


    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit) : Apis = retrofit.create(Apis::class.java)


}