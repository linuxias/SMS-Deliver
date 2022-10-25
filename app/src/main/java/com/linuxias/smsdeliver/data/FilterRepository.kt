package com.linuxias.smsdeliver.data

import androidx.annotation.WorkerThread

interface FilterRepository {
    suspend fun insert(filterEntity: FilterEntity)

    fun getAllFilters() : List<FilterEntity>

    suspend fun deleteFilter(filterEntity: FilterEntity)
}