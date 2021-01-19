package com.bellemaxime.github.presentation.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.bellemaxime.github.data.repository.SearchUserRepository
import com.bellemaxime.github.domain.repository.UserRepository
import kotlinx.coroutines.launch

class DetailViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: UserRepository = SearchUserRepository()


    private val _state = MutableLiveData<DetailState>()
    val state: LiveData<DetailState> get() = _state

    fun getUserDetail(login: String) {
        _state.value = DetailState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = DetailState.SuccessState(repository.getUserDetail(login))
            } catch (e: Exception) {
                println("erreur")
                println(e)
                _state.value = DetailState.ErrorState
            }
        }
    }
}