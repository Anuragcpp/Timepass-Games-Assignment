package com.example.dogimagegenerator.domain.di

import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import com.example.dogimagegenerator.domain.usecases.DeleteAllDogImageUseCase
import com.example.dogimagegenerator.domain.usecases.GetAllDogImageUseCase
import com.example.dogimagegenerator.domain.usecases.GetDogImageUsageCase
import com.example.dogimagegenerator.domain.usecases.InsertDogImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    fun provideGetDogImageUseCase(imagerRepository: DogImagerRepository) : GetDogImageUsageCase{
        return GetDogImageUsageCase(imagerRepository)
    }

    @Provides
    fun provideInsertDogImageUseCase(imagerRepository: DogImagerRepository) : InsertDogImageUseCase {
        return InsertDogImageUseCase(imagerRepository)
    }

    @Provides
    fun provideGetAllDogImageUseCase(repository : DogImagerRepository) : GetAllDogImageUseCase {
        return GetAllDogImageUseCase(repository)
    }

    @Provides
    fun provideDeleteAllDogImageUseCase(repository: DogImagerRepository) : DeleteAllDogImageUseCase{
        return DeleteAllDogImageUseCase(repository)
    }

}