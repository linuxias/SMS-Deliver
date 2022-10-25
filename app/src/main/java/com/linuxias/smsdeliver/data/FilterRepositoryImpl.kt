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
    override fun getAllFilters() : List<FilterEntity> {
        return filterDao.getAllFilters()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    override suspend fun deleteFilter(filterEntity: FilterEntity) {
        filterDao.deleteFilter(filterEntity)
    }
}