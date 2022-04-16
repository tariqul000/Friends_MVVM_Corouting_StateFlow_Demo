package com.tariqul.friendsdemoproject.data.repository

import com.tariqul.friendsdemoproject.data.model.BaseUsersDataModel
import com.tariqul.friendsdemoproject.util.Resource
import kotlinx.coroutines.flow.Flow

interface UsersRepository{

    // Home Data API calling repository
    suspend fun getUsersData(): Flow<Resource<BaseUsersDataModel>>

}