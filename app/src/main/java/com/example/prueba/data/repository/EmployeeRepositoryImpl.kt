package com.example.prueba.data.repository

import com.example.prueba.data.errors.ConnectionException
import com.example.prueba.data.source.hardware.Connections
import com.example.prueba.data.source.local.interfaces.EmployeeLocalSource
import com.example.prueba.data.source.remote.EmployeeRemoteSource
import com.example.prueba.domain.entities.Employee
import com.example.prueba.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class EmployeeRepositoryImpl @Inject constructor(
    val employeeLocalSource: EmployeeLocalSource,
    val employeeRemoteSource: EmployeeRemoteSource,
    val connections: Connections
): EmployeeRepository {

    override suspend fun getEmployees(): Flow<List<Employee>> = employeeLocalSource.getEmployees()

    override suspend fun syncEmployees(auditory: String, criterion: String): Boolean {
        if (!connections.isThereNetworkConnection()) throw ConnectionException("There isn't network connection")
        val employees = employeeRemoteSource.getEmployeesByAuditoryAndCriterion(auditory, criterion)
        employeeLocalSource.saveEmployees(employees)
        return true
    }
}