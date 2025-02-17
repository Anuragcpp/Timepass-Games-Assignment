package com.example.dogimagegenerator.common

import com.example.dogimagegenerator.data.dto.ApiResponseDTO
import com.example.dogimagegenerator.domain.model.ImageUrl

fun ApiResponseDTO.toDomainInModel() : ImageUrl{
    return ImageUrl(imageUrl = this.data)
}