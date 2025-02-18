package com.example.dogimagegenerator.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dogimagegenerator.data.local.entity.DBImageUrl
import kotlinx.coroutines.flow.Flow

@Dao
interface DogImageDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(dbImageUrl : DBImageUrl)

    @Query("SELECT * FROM dog_images ORDER BY id DESC LIMIT 20")
    fun getRecentImages() : Flow<List<DBImageUrl>>

    @Query("DELETE FROM dog_images")
    suspend fun clearAllImages()
}