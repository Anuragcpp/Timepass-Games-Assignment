package com.example.dogimagegenerator.data.repository

import com.example.dogimagegenerator.common.toDomainInModel
import com.example.dogimagegenerator.data.remote.ApiService
import com.example.dogimagegenerator.domain.model.ImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import java.lang.Exception

class DogImageRepositryImp ( private val apiService: ApiService) : DogImagerRepository {
    override suspend fun getDogImageFromApi(): ImageUrl {
        try {
            return apiService.getDogImage().toDomainInModel()
        }catch ( e : Exception){
            throw Exception(e)
        }
    }
}