package com.linuxias.smsdeliver.data

import androidx.annotation.WorkerThread

class FilterRepositoryImpl(private val filterDao: FilterDao): FilterRepository {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun insert(filterEntity: FilterEntity) {
        filterDao.insertFilter(filterEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun getAllFilters() : Result<List<FilterEntity>> {
        return Result.Success(filterDao.getAllFilters())
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun deleteFilter(filterEntity: FilterEntity) {
        filterDao.deleteFilter(filterEntity)
    }

    override suspend fun getFilterById(filterID: String): Result<FilterEntity> {
        try {
            val entity = filterDao.getFilterById(filterID)
            if (entity != null) {
                return Result.Success(entity)
            } else {
                return Result.Error(Exception("Entity not found"))
            }
        } catch (e: Exception) {
            return Result.Error(e)
        }
    }
}