package com.linuxias.smsdeliver.data

import androidx.annotation.WorkerThread

interface FilterRepository {
    suspend fun insert(filterEntity: FilterEntity)

    fun getAllFilters() : List<FilterEntity>

    suspend fun deleteFilter(filterEntity: FilterEntity)

    suspend fun getFilterById(filterID: String) : Result<FilterEntity>
}