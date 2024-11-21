package com.mogun.todo.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Content")
data class ContentEntity (
    @PrimaryKey(true)
    val id: Int = 0,

    @ColumnInfo
    var content: String,

    @ColumnInfo
    var memo: String? = null,

    @ColumnInfo
    var isDone: Boolean = false,
)