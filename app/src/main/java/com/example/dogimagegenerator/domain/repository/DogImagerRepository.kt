package com.example.dogimagegenerator.domain.repository

import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import com.example.dogimagegenerator.domain.model.ImageUrl
import kotlinx.coroutines.flow.Flow

interface DogImagerRepository {

    suspend fun getDogImageFromApi() : ImageUrl

    suspend fun saveImageToDB(dbImageUrl: DBImageUrl)

    suspend fun clearAllImages()

    fun getMyRecentGeneratedPhotos () : Flow<List<DBImageUrl>>
}