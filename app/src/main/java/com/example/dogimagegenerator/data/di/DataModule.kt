package com.example.dogimagegenerator.data.di

import com.example.dogimagegenerator.data.remote.ApiService
import com.example.dogimagegenerator.data.repository.DogImageRepositryImp
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    private const val BASE_URL = "https://dog.ceo/"

    @Provides
    fun providesApiService() : ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)
    }

    @Provides
    fun provideDogImageRepo(apiService: ApiService) : DogImagerRepository {
        return DogImageRepositryImp(apiService)
    }
}