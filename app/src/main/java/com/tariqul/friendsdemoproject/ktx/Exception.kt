package com.tariqul.friendsdemoproject.ktx

import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException


fun Exception.getUserFriendlyErrorMessage(): String {

    val userFriendMessage = when (this) {
        is IOException -> return "Check your internet connection."
        is NullPointerException -> return "Failed to process the data from server."
        is IllegalStateException -> return "Failed to process the data from server."
        is HttpException -> {

            return when (code()) {
                401 -> "You need to login to access the data."
                403 -> "Sorry. We can't provide the data now. Try again later."
                404 -> "Sorry. No data exist."
                500 -> "Sorry. You need to be logged in to access the data."
                else -> "Server didn't respond."
            }
        }
        else -> "Could not load the data."
    }

    return userFriendMessage


}

fun Response<*>.getUserFriendlyMessageFromResponse(): String {
    return when (code()) {
        401 -> "You need to login to access the data."
        403 -> "Sorry. We can't provide the data now. Try again later."
        404 -> "Sorry. No data exist."
        500 -> "Sorry. You authentication session has ended."
        else -> "Server didn't respond."
    }
}

