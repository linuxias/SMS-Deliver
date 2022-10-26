package com.linuxias.smsdeliver.repository

import com.linuxias.smsdeliver.data.FilterEntity
import com.linuxias.smsdeliver.data.FilterRepository

class FakeFilterRepository: FilterRepository {
    private val filters = mutableListOf<FilterEntity>()

    override suspend fun insert(filterEntity: FilterEntity) {
        filters.add(filterEntity)
    }

    override fun getAllFilters(): List<FilterEntity> {
        return filters
    }

    override suspend fun deleteFilter(filterEntity: FilterEntity) {
        filters.remove(filterEntity)
    }

}