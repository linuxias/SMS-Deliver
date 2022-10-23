package com.linuxias.smsdeliver.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.linuxias.smsdeliver.data.FilterEntity
import com.linuxias.smsdeliver.data.FilterRepository
import kotlinx.coroutines.launch

class FilterViewModel(private val repository: FilterRepository): ViewModel() {
    fun insertFilter(number: String, filter: String) = viewModelScope.launch {
        repository.insert(FilterEntity(number, filter))
    }

    fun getAllFilters() : List<FilterEntity> {
        return repository.getAllFilters()
    }
}

class FilterViewModelFactory(private val repository: FilterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FilterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FilterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}