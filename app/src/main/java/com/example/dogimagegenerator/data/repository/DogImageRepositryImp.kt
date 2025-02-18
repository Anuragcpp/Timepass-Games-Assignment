package com.example.dogimagegenerator.data.repository

import android.util.Log
import com.example.dogimagegenerator.common.toDomainInModel
import com.example.dogimagegenerator.data.local.dao.DogImageDao
import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import com.example.dogimagegenerator.data.remote.ApiService
import com.example.dogimagegenerator.domain.model.ImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.lang.Exception

class DogImageRepositryImp (
    private val apiService: ApiService,
    private val dogImageDao: DogImageDao
) : DogImagerRepository {
    override suspend fun getDogImageFromApi(): ImageUrl {
        try {
//            val rowData = apiService.getDogImage()
//            Log.d("Completed Row Data", "$rowData")
//            Log.d("Row DATA","Data -> ${rowData.status} , message -> ${rowData.message}")
//            val data : ImageUrl = rowData.toDomainInModel()
//            Log.d("Transformed DATA", "After converstion ${data}", )
            return apiService.getDogImage().toDomainInModel()
            //return apiService.getDogImage().toDomainInModel()
        }catch ( e : Exception){
            throw Exception(e)
        }
    }

    //val recentImages : Flow<List<DBImageUrl>> = dogImageDao.getRecentImages()



    override suspend fun saveImageToDB(dbImageUrl: DBImageUrl) {
        try {
            dogImageDao.insertImage(dbImageUrl)
        }catch (e : IOException){
            Log.d("Error in saving Image", "error -> ${e.message}")
        }
    }

    override suspend fun clearAllImages() {
        try {
            dogImageDao.clearAllImages()
        }catch (e : IOException){
            Log.d("Error in Clearing Image", "error -> ${e.message}")
        }
    }

    override fun getMyRecentGeneratedPhotos(): Flow<List<DBImageUrl>> {
        return try {
            dogImageDao.getRecentImages()
        }catch (e : IOException){
            throw IOException("Error in fetching data form Room")
        }
    }
}