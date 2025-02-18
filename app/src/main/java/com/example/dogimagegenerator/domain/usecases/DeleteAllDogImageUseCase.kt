package com.example.dogimagegenerator.domain.usecases

import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import javax.inject.Inject

class DeleteAllDogImageUseCase @Inject constructor(private val repository: DogImagerRepository) {
    suspend operator fun invoke(){
        repository.clearAllImages()
    }
}