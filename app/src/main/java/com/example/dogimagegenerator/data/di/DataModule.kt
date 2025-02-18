package com.example.dogimagegenerator.data.di

import android.content.Context
import androidx.room.Room
import com.example.dogimagegenerator.data.local.AppDB
import com.example.dogimagegenerator.data.local.dao.DogImageDao
import com.example.dogimagegenerator.data.remote.ApiService
import com.example.dogimagegenerator.data.repository.DogImageRepositryImp
import com.example.dogimagegenerator.domain.repository.DogImagerRepository
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDB {
        return Room.databaseBuilder(
            context.applicationContext,
            AppDB::class.java,
            "Application.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideDogDao(database: AppDB): DogImageDao {
        return database.dogImageDao()
    }

    @Provides
    fun provideDogImageRepo(apiService: ApiService,dogImageDao: DogImageDao) : DogImagerRepository {
        return DogImageRepositryImp(apiService,dogImageDao)
    }


}