package com.example.prueba.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.prueba.data.source.local.daos.EmployeeDao
import com.example.prueba.data.source.local.entities.Employee

@Database(entities = [Employee::class], version = 1)
abstract class TestDataBase: RoomDatabase() {
    abstract fun getEmployeesDao(): EmployeeDao
}