package com.bellemaxime.github.data.model

import com.google.gson.annotations.SerializedName

data class UserGitUserShort(
    @SerializedName("id")
    val id: Int,
    @SerializedName("login")
    val login: String,
    @SerializedName("avatar_url")
    val avatar: String,
)
