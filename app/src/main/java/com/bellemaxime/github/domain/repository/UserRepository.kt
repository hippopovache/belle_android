package com.bellemaxime.github.domain.repository

import com.bellemaxime.github.domain.model.UserDetail
import com.bellemaxime.github.domain.model.UserShort

interface UserRepository {

    suspend fun searchUser(search: String): List<UserShort>

    suspend fun getUserDetail(login: String): List<UserDetail>
}