package com.tariqul.friendsdemoproject.ui.uistate

import com.tariqul.friendsdemoproject.data.model.UsersDataModel


data class UsersFragmentUIState(
    val usersDataModel: List<UsersDataModel> = emptyList(),
    val isLoading : Boolean = false,
    val message : String = ""
)