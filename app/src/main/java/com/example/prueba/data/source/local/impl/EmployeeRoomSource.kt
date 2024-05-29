package com.example.prueba.data.source.local.impl

import com.example.prueba.data.source.local.TestDataBase
import com.example.prueba.data.source.local.interfaces.EmployeeLocalSource
import com.example.prueba.data.source.local.mappers.EmployeeMapper
import com.example.prueba.domain.entities.Employee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class EmployeeRoomSource @Inject constructor(
    val testDataBase: TestDataBase,
    val employeeMappers: EmployeeMapper
): EmployeeLocalSource {
    override suspend fun getEmployees(): Flow<List<Employee>> = testDataBase.getEmployeesDao().getEmployees().map {
        it.map(employeeMappers::toEmployeeDomain)
    }

    override suspend fun saveEmployees(employees: List<Employee>) {
        val employeesData = employees.map(employeeMappers::toEmployeeData)
        testDataBase.getEmployeesDao().insertEmployees(employeesData)
    }
}