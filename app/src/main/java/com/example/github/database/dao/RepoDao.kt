package com.example.github.database.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.github.database.entity.DatabaseRepo

@Dao
interface RepoDao {

    @Query("SELECT * FROM repos_table")
    fun getRepos(): DataSource.Factory<Int, DatabaseRepo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(repos: List<DatabaseRepo>)

    @Query("DELETE FROM repos_table")
    fun deleteAll()
}
