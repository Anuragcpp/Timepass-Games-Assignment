package com.example.dogimagegenerator.domain.di

import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import com.example.dogimagegenerator.domain.usecases.GetDogImageUsageCase
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

}