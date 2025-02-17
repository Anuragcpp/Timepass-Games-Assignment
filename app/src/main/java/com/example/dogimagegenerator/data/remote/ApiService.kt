package com.example.dogimagegenerator.data.remote

import com.example.dogimagegenerator.data.dto.ApiResponseDTO
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    //https://dog.ceo/api/breeds/image/random

    @GET("api/breeds/image/random")
    suspend fun getDogImage() : ApiResponseDTO
}