package com.example.prueba.data.source.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey val email: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "position") val position: String
)
