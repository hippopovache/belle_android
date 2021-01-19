package com.bellemaxime.github.domain.model

import com.bellemaxime.github.data.model.License

data class UserDetail(
    val id: Int,
    val name: String?,
    val description: String?,
    val language: String?,
    val forks: String?,
    val watchers: String?,
    val license: License?,
)