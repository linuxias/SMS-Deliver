package com.linuxias.smsdeliver.repository

import com.linuxias.smsdeliver.data.FilterEntity
import com.linuxias.smsdeliver.data.FilterRepository
import com.linuxias.smsdeliver.data.Result
import kotlinx.coroutines.flow.*

class FakeFilterRepository: FilterRepository {
    private val _savedFilterEntities = MutableStateFlow(LinkedHashMap<String, FilterEntity>())
    var savedFilterEntity :StateFlow<LinkedHashMap<String, FilterEntity>> = _savedFilterEntities.asStateFlow()

    private val observableFilterEntities: Flow<Result<List<FilterEntity>>> = savedFilterEntity.map {
        Result.Success(it.values.toList())
    }

    override suspend fun insert(filterEntity: FilterEntity) {
        _savedFilterEntities.update { filters ->
            val newFilterEntities = LinkedHashMap<String, FilterEntity>()
            newFilterEntities[filterEntity.id] = filterEntity
            newFilterEntities
        }
    }

    override suspend fun getAllFilters(): Result<List<FilterEntity>> {
        return observableFilterEntities.first()
    }

    override suspend fun deleteFilter(filterEntity: FilterEntity) {
        _savedFilterEntities.update { filters ->
            val newFilterEntities = LinkedHashMap<String, FilterEntity>(filters)
            newFilterEntities.remove(filterEntity.id)
            newFilterEntities
        }
    }

    override suspend fun getFilterById(filterID: String): Result<FilterEntity> {
        savedFilterEntity.value[filterID]?.let {
            return Result.Success(it)
        }
        return Result.Error(Exception("Not found"))
    }
}