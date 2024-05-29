package com.example.prueba.domain.uc

import com.example.prueba.domain.entities.Employee
import com.example.prueba.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetEmployeesUc @Inject constructor(
    val repository: EmployeeRepository
) {
    suspend fun getEmployeesFlow(): Flow<List<Employee>> = repository.getEmployees()
}