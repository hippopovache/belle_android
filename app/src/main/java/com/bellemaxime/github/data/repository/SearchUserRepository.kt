package com.bellemaxime.github.data.repository

import com.bellemaxime.github.data.api.UserGitApi
import com.bellemaxime.github.data.model.UserGitUserDetail
import com.bellemaxime.github.data.model.UserGitUserShort
import com.bellemaxime.github.domain.model.UserDetail
import com.bellemaxime.github.domain.model.UserShort
import com.bellemaxime.github.domain.repository.UserRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SearchUserRepository : UserRepository {

    private val retrofit: Retrofit

    init {

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl(UserGitApi.BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private val api = retrofit.create(UserGitApi::class.java)

    override suspend fun searchUser(search: String): List<UserShort> {
        return api.searchUser(search).gitUsers.map {
            it.toUserShort()
        }
    }

    override suspend fun getUserDetail(login: String): List<UserDetail> {
        return api.getUserDetail(login).map {
            it.toUserDetail()
        }
    }

    fun UserGitUserShort.toUserShort() = UserShort(this.id, this.login, this.avatar)

    fun UserGitUserDetail.toUserDetail() = UserDetail(
        this.id,
        this.name,
        this.description,
        this.language,
        this.forks,
        this.watchers,
        this.license,
    )
}