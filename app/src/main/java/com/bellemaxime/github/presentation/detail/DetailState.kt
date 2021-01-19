package com.bellemaxime.github.presentation.detail

import com.bellemaxime.github.domain.model.UserDetail

sealed class DetailState {
    class SuccessState(val user: List<UserDetail>) : DetailState()

    object ErrorState : DetailState()

    object LoadingState : DetailState()
}
