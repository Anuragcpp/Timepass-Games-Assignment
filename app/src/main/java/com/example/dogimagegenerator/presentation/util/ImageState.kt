package com.example.dogimagegenerator.presentation.util

import com.example.dogimagegenerator.domain.model.ImageUrl

data class ImageState(
    val isLoading : Boolean = false,
    val data : ImageUrl? = null,
    val error : String = ""
)
