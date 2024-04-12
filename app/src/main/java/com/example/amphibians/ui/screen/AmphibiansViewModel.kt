package com.example.amphibians.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibians.ui.data.Amphibian
import com.example.amphibians.ui.data.NetworkAmphibianPhotoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class ResponseState() {
    class isLoading : ResponseState()
    data class isSuccess(val photoList: List<Amphibian>) : ResponseState()
    data class isError(val error: Exception) : ResponseState()
}

class AmphibiansViewModel(val repository: NetworkAmphibianPhotoRepository) : ViewModel() {
    private val _uiState = MutableStateFlow<ResponseState>(ResponseState.isLoading())
    val uiState: StateFlow<ResponseState> = _uiState.asStateFlow()

    init {
        getPhotoList()
    }

    fun getPhotoList() {
        viewModelScope.launch {
            try {
                val photoList = repository.getPhotoList()
                _uiState.value = ResponseState.isSuccess(photoList)
            } catch (e: Exception) {
                _uiState.value = ResponseState.isError(e)
            }
        }

    }
}