package com.tariqul.friendsdemoproject.apiCall

import com.tariqul.friendsdemoproject.data.model.BaseUsersDataModel
import retrofit2.Call
import retrofit2.http.GET

interface Apis {
    @GET("?results=10")
    suspend fun getUsers(): Call<BaseUsersDataModel>
}