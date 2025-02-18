package com.example.dogimagegenerator.domain.usecases

import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllDogImageUseCase @Inject constructor(private val repository: DogImagerRepository) {
    operator fun invoke() : Flow<List<DBImageUrl>> {
        return repository.getMyRecentGeneratedPhotos()
    }
}