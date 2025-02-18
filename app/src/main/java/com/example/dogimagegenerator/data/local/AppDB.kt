package com.example.dogimagegenerator.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.dogimagegenerator.data.local.dao.DogImageDao
import com.example.dogimagegenerator.data.local.entity.DBImageUrl

@Database(entities = [DBImageUrl::class], version = 1, exportSchema = false)
abstract class AppDB : RoomDatabase(){
    abstract fun dogImageDao() : DogImageDao

//    companion object {
//        @Volatile
//        private var INSTANCE: AppDB? = null
//
//        fun getDatabase(context: Context): AppDB {
//            return INSTANCE ?: synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDB::class.java,
//                    "Application.db"
//                ).build()
//                INSTANCE = instance
//                instance
//            }
//        }
//    }
}