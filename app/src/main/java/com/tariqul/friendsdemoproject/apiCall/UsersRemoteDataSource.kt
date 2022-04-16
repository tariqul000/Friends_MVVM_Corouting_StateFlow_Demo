package com.tariqul.friendsdemoproject.apiCall

import android.util.Log
import com.tariqul.friendsdemoproject.ktx.getUserFriendlyErrorMessage
import com.tariqul.friendsdemoproject.data.model.BaseUsersDataModel
import com.tariqul.friendsdemoproject.util.DispatcherProvider
import com.tariqul.friendsdemoproject.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.awaitResponse
import javax.inject.Inject

class UsersRemoteDataSource @Inject constructor(
    private val api: Apis,
    private val dispatcherProvider: DispatcherProvider,

    ) {

    suspend fun getUsersData(): Flow<Resource<BaseUsersDataModel>> {
        return flow {
            emit(Resource.Loading())
            try {
                val response = api.getUsers().awaitResponse()
                Log.d("APIResponse: ", response.toString())
                if (response.isSuccessful && response.body() != null){
                    emit(Resource.Success(response.body()!!))
                }

            } catch (e: Exception){
                Log.d("APIResponse: error", e.message.toString())

                emit(
                    Resource.Error(e.getUserFriendlyErrorMessage())
                )
            }
        }.flowOn(dispatcherProvider.io)
    }

}