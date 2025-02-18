package com.example.dogimagegenerator.domain.usecases

import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import javax.inject.Inject

class InsertDogImageUseCase @Inject constructor(private val repository: DogImagerRepository) {
    suspend operator fun invoke(dbImageUrl: DBImageUrl){
        repository.saveImageToDB(dbImageUrl)
    }
}