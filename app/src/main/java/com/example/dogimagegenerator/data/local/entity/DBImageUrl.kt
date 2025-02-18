package com.example.dogimagegenerator.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dog_images")
data class DBImageUrl(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val imageUrl : String
)