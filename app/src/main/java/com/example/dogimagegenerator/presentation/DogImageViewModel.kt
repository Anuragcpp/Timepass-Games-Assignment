package com.example.dogimagegenerator.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.PrimaryKey
import com.example.dogimagegenerator.common.Resource
import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import com.example.dogimagegenerator.domain.usecases.DeleteAllDogImageUseCase
import com.example.dogimagegenerator.domain.usecases.GetAllDogImageUseCase
import com.example.dogimagegenerator.domain.usecases.GetDogImageUsageCase
import com.example.dogimagegenerator.domain.usecases.InsertDogImageUseCase
import com.example.dogimagegenerator.presentation.util.ImageState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DogImageViewModel @Inject constructor(
    private val getDogImageUsageCase: GetDogImageUsageCase,
    private val getAllDogImageUseCase: GetAllDogImageUseCase,
    private val insertDogImageUseCase: InsertDogImageUseCase,
    private val deleteAllDogImageUseCase: DeleteAllDogImageUseCase
)
    : ViewModel()
{
        private val _image = mutableStateOf(ImageState())
    val image : State<ImageState> get() = _image

    //val cachedDogImages : Flow<List<DBImageUrl>> =



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
                    Log.d("MyURl","data -> ${it.data?.imageUrl}")
                    _image.value = ImageState(data = it.data )
                    //save the image to Room Db
                    it.data.let {
                        if (it != null) {
                            insertDogImageUseCase.invoke(
                                DBImageUrl(imageUrl = it.imageUrl)
                            )
                        }
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    val cachedDogImages : Flow<List<DBImageUrl>> = getAllDogImageUseCase()

    fun clearCache() {
        viewModelScope.launch {
            deleteAllDogImageUseCase.invoke()
        }
    }




}