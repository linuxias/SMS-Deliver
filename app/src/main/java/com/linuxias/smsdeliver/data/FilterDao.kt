package com.linuxias.smsdeliver.data

import androidx.room.*

@Dao
interface FilterDao {
    @Query("SELECT * FROM FilterTable")
    fun getAllFilters(): List<FilterEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilter(filter: FilterEntity)

    @Delete
    suspend fun deleteFilter(filter: FilterEntity)
}