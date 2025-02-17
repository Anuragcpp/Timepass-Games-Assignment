package com.example.dogimagegenerator.domain.repository

import com.example.dogimagegenerator.domain.model.ImageUrl

interface DogImagerRepository {

    suspend fun getDogImageFromApi() : ImageUrl
}