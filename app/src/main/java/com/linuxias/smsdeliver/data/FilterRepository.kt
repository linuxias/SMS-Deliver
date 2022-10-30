package com.linuxias.smsdeliver.data

interface FilterRepository {
    suspend fun insert(filterEntity: FilterEntity)

    suspend fun getAllFilters() : Result<List<FilterEntity>>

    suspend fun deleteFilter(filterEntity: FilterEntity)

    suspend fun getFilterById(filterID: String) : Result<FilterEntity>
}