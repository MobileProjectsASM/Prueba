package com.example.prueba.data.source.local.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.prueba.data.source.local.entities.Employee
import kotlinx.coroutines.flow.Flow

@Dao
interface EmployeeDao {

    @Insert
    fun insertEmployees(employee: List<Employee>)

    @Query("SELECT * FROM employee")
    fun getEmployees(): Flow<List<Employee>>
}