package com.bellemaxime.github.data.model

import com.google.gson.annotations.SerializedName

data class UserGitSearchResponse(
    @SerializedName("items")
    val gitUsers: List<UserGitUserShort>,
)
