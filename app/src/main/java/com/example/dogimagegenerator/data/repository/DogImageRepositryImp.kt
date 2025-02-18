package com.example.dogimagegenerator.data.repository

import android.util.Log
import com.example.dogimagegenerator.common.toDomainInModel
import com.example.dogimagegenerator.data.remote.ApiService
import com.example.dogimagegenerator.domain.model.ImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import java.lang.Exception

class DogImageRepositryImp ( private val apiService: ApiService) : DogImagerRepository {
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
}