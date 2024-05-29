package com.example.prueba.data.source.local.interfaces

import com.example.prueba.domain.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeLocalSource {
    suspend fun getEmployees(): Flow<List<Employee>>
    suspend fun saveEmployees(employees: List<Employee>)
}