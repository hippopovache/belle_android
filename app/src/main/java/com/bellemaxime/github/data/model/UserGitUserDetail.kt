package com.bellemaxime.github.data.model

import com.google.gson.annotations.SerializedName

data class UserGitUserDetail(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("forks")
    val forks: String,
    @SerializedName("watchers")
    val watchers: String,
    @SerializedName("license")
    val license: License?,
    @SerializedName("forks_count")
    val resultNumber: Int,
)

