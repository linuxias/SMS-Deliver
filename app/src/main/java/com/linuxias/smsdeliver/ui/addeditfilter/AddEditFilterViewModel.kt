package com.linuxias.smsdeliver.ui.addeditfilter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.linuxias.smsdeliver.R
import com.linuxias.smsdeliver.data.FilterEntity
import com.linuxias.smsdeliver.data.FilterRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.security.InvalidParameterException

class FilterViewModel(
    private val repository: FilterRepository,
): ViewModel() {
    fun saveFilter(number: String, filter: String, filterID: String? = null) {
        if (number.isEmpty() || filter.isEmpty()) {
            throw InvalidParameterException("Invalid parameter")
        }

        if (filterID == null)
            createNewFilter(number, filter)
        else
            updateExistedFilter(filterID, number, filter)
    }

    private fun createNewFilter(number: String, filter: String) = viewModelScope.launch {
        val filter = FilterEntity(number, filter)
        repository.insert(filter)
    }

    private fun updateExistedFilter(filterID: String, number: String, filter: String) = viewModelScope.launch {
        val filterEntity = FilterEntity(number, filter, filterID)
        repository.insert(filterEntity)
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