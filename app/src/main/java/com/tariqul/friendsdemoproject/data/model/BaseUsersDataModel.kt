package com.tariqul.friendsdemoproject.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class BaseUsersDataModel(
    @SerializedName("results")
    var result: List<UsersDataModel>
): Serializable

data class UsersDataModel (
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
) : Serializable


data class Name(
    @SerializedName("title")
    val title: String,
    @SerializedName("first")
    val first: String,
    @SerializedName("last")
    val last: String,
): Serializable

data class Location(

    @SerializedName("city")
    val city: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("street")
    var street: Street,
): Serializable

data class Picture(
    @SerializedName("medium")
    val medium: String,
    @SerializedName("large")
    val large: String,
    @SerializedName("thumbnail")
    val thumb: String
): Serializable

data class Street(
    @SerializedName("number")
    val number: String,
    @SerializedName("name")
    val name: String
): Serializable