package com.example.prueba.data.source.remote.mappers

import com.example.prueba.data.source.remote.model.Employee
import com.example.prueba.domain.entities.Employee as EmployeeDomain

class EmployeeMapper {
    fun toEmployee(employee: Employee) : EmployeeDomain = EmployeeDomain(
        employee.email ?: "",
        employee.name ?: "",
        employee.position ?: ""
    )
}