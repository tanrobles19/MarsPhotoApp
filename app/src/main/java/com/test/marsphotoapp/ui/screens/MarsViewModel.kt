package com.test.marsphotoapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.marsphotoapp.network.MarsApi
import kotlinx.coroutines.launch

sealed interface MarsUIState{
    data class Success(val photo: String) :MarsUIState
    object Error: MarsUIState
    object Loading: MarsUIState
}

class MarsViewModel: ViewModel() {

    var marsUIState : MarsUIState by mutableStateOf(MarsUIState.Loading)

    init {
        getMarsPhotos()
    }

    fun getMarsPhotos() {
        viewModelScope.launch {
            val photoList = MarsApi.retrofitService.getPhotos()
            marsUIState = MarsUIState.Success(photoList.toString())
        }
    }

}