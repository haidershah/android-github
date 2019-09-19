package com.example.github.work

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.github.database.RepoDatabase
import com.example.github.repository.ReposRepository
import retrofit2.HttpException

class RefreshDataWorker(appContext: Context, params: WorkerParameters) :
    CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        val database = RepoDatabase.getInstance(applicationContext)
        val repository = ReposRepository(database)

        return try {
            repository.getRepos("haidershah")
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}
