package com.example.dogimagegenerator.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogimagegenerator.common.Resource
import com.example.dogimagegenerator.domain.usecases.GetDogImageUsageCase
import com.example.dogimagegenerator.presentation.util.ImageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class DogImageViewModel @Inject constructor(private val getDogImageUsageCase: GetDogImageUsageCase)
    : ViewModel()
{
        private val _image = mutableStateOf(ImageState())
    val image : State<ImageState> get() = _image

    init {
        getImage()
    }

    fun getImage() {
        getDogImageUsageCase().onEach {
            when(it){
                is Resource.Loading -> {
                    _image.value = ImageState(isLoading = true)
                }
                is Resource.Error -> {
                    _image.value = ImageState(error = it.message.toString())
                }

                is Resource.Success -> {
                    _image.value = ImageState(data = it.data )
                }
            }
        }.launchIn(viewModelScope)
    }


}