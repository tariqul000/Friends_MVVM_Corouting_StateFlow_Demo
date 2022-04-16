package com.tariqul.friendsdemoproject.data.repository

import com.tariqul.friendsdemoproject.apiCall.UsersRemoteDataSource
import com.tariqul.friendsdemoproject.data.model.BaseUsersDataModel
import com.tariqul.friendsdemoproject.util.DispatcherProvider
import com.tariqul.friendsdemoproject.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UsersDefaultRepository @Inject constructor(
    private  val usersRemoteDataSource: UsersRemoteDataSource,
    private val dispatcherProvider: DispatcherProvider,
) : UsersRepository {
    override suspend fun getUsersData(): Flow<Resource<BaseUsersDataModel>> {
        return usersRemoteDataSource.getUsersData()
    }

}