package com.bellemaxime.github.data.api

import com.bellemaxime.github.data.model.UserGitSearchResponse
import com.bellemaxime.github.data.model.UserGitUserDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserGitApi {
    companion object {
        const val BASE_URL = "https://api.github.com"
    }

    @GET("/search/users")
    suspend fun searchUser(
        @Query("q") title: String,
    ): UserGitSearchResponse


    @GET("/users/{login}/repos")
    suspend fun getUserDetail(
        @Path("login") login: String,
    ): List<UserGitUserDetail>
}