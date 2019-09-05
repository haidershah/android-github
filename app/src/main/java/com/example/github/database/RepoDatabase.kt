package com.example.github.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.github.database.dao.RepoDao
import com.example.github.database.entity.DatabaseRepo

@Database(entities = [DatabaseRepo::class], version = 1)
abstract class RepoDatabase : RoomDatabase() {

    abstract val dao: RepoDao

    companion object {
        @Volatile
        private lateinit var INSTANCE: RepoDatabase

        fun getInstance(context: Context): RepoDatabase {
            synchronized(this) {
                if (!::INSTANCE.isInitialized) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        RepoDatabase::class.java,
                        "repos_database"
                    ).build()
                }
                return INSTANCE
            }
        }
    }
}
