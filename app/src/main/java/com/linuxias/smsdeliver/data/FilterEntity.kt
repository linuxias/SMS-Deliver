package com.linuxias.smsdeliver.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FilterTable")
data class FilterEntity (
    @ColumnInfo
    val receiverNumber: String,

    @ColumnInfo
    val filterRegex: String,

    @PrimaryKey(autoGenerate=true)
    val id : Int = 0,
)