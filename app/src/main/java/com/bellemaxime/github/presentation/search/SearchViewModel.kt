package com.bellemaxime.github.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bellemaxime.github.data.repository.SearchUserRepository
import com.bellemaxime.github.domain.repository.UserRepository
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val repository: UserRepository = SearchUserRepository()

    private val _state = MutableLiveData<SearchState>()
    val state: LiveData<SearchState> get() = _state

    fun searchUser(text: String) {
        _state.value = SearchState.LoadingState

        viewModelScope.launch {
            try {
                _state.value = SearchState.SuccessState(repository.searchUser(text))
            } catch (e: Exception) {
                _state.value = SearchState.ErrorState
            }
        }
    }
}