package com.tariqul.friendsdemoproject.ui.viewmodel


import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tariqul.friendsdemoproject.data.repository.UsersRepository
import com.tariqul.friendsdemoproject.ui.uistate.UsersFragmentUIState
import com.tariqul.friendsdemoproject.util.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class UsersViewModel
@Inject constructor(
    private val homeRepository: UsersRepository,
    private val dispatcher: DispatcherProvider,
) : ViewModel() {

    private val _userFragmentUiState = MutableStateFlow(UsersFragmentUIState())
    val userFragmentUIState = _userFragmentUiState.asStateFlow()

    private var fetchHomeDataJob: Job? = null
    fun getHomeData(){
        fetchHomeDataJob?.cancel()
        fetchHomeDataJob = viewModelScope.launch(){
            _userFragmentUiState.update { it.copy(isLoading = true) }

            homeRepository.getUsersData().collect{ resource ->
                _userFragmentUiState.update {
                    Log.d("Data: ", resource.data.toString())
                    it.copy(
                        isLoading = false,
                        // Log.d("usersDataModel   ", resource.data.toString())
                        usersDataModel = resource.data?.result ?: emptyList()

                    )

                }
            }
       }
    }


}