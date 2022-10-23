package com.linuxias.smsdeliver.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [FilterEntity::class],
    version = 1
)
abstract class FilterDatabase: RoomDatabase() {
    abstract fun filterDao(): FilterDao

    companion object {
        @Volatile
        private var INSTANCE: FilterDatabase? = null

        fun getDatabase(context: Context): FilterDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FilterDatabase::class.java,
                    "exercise_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}