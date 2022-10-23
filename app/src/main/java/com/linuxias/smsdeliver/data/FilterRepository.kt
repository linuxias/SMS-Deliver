package com.linuxias.smsdeliver.data

import androidx.annotation.WorkerThread

class FilterRepository(private val filterDao: FilterDao) {
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(filterEntity: FilterEntity) {
        filterDao.insertFilter(filterEntity)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getAllFilters() : List<FilterEntity> {
        return filterDao.getAllFilters()
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteFilter(filterEntity: FilterEntity) {
        filterDao.deleteFilter(filterEntity)
    }
}