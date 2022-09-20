package com.linuxias.smsdeliver.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FilterTable")
data class FilterEntity (
    @PrimaryKey(autoGenerate=true)
    var id : Int? = null,

    @ColumnInfo
    val receiverNumber: String,

    @ColumnInfo
    val filterRegex: String
)