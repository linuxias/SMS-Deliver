package com.linuxias.smsdeliver.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "FilterTable")
data class FilterEntity (
    @ColumnInfo(name = "number")
    val receiverNumber: String,

    @ColumnInfo(name = "regex")
    val filterRegex: String,

    @PrimaryKey @ColumnInfo(name = "filterID")
    var id: String = UUID.randomUUID().toString()
)