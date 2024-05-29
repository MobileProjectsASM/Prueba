package com.example.prueba.domain.repository

import com.example.prueba.domain.entities.Employee
import kotlinx.coroutines.flow.Flow

interface EmployeeRepository {
    suspend fun getEmployees(): Flow<List<Employee>>
    suspend fun syncEmployees(): Boolean
}