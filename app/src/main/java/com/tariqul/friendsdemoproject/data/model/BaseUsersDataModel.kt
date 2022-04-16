package com.tariqul.friendsdemoproject.data.model

import com.google.gson.annotations.SerializedName


data class BaseUsersDataModel(
    @SerializedName("results")
    var result: List<UsersDataModel>
)

data class UsersDataModel(
    @SerializedName("gender")
    var gender: String,
    @SerializedName("name")
    var name: Name,
    @SerializedName("location")
    var location: Location,
    @SerializedName("email")
    var email: String,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("cell")
    var cell: String,
    @SerializedName("picture")
    var picture: Picture,
)


data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String
)

data class Location(

    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String
)

data class Picture(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("large")
    val large: String,
    @SerializedName("thumbnail")
    val thumb: String
)