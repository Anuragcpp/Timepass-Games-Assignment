package com.example.dogimagegenerator.domain.usecases

import com.example.dogimagegenerator.common.Resource
import com.example.dogimagegenerator.domain.model.ImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class GetDogImageUsageCase (private val imagerRepository: DogImagerRepository) {
    operator fun invoke() : Flow<Resource<ImageUrl>> = flow{
        emit(Resource.Loading())
        try{
            emit(Resource.Success(imagerRepository.getDogImageFromApi()))
        }catch ( e : Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }
}