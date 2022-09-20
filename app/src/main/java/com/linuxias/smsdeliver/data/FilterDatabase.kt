package com.linuxias.smsdeliver.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FilterEntity::class],
    version = 1
)
abstract class FilterDatabase: RoomDatabase() {
    abstract fun filterDao(): FilterDao
}