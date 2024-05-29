package com.example.prueba.data.source.local.mappers

import com.example.prueba.data.source.local.entities.Employee
import com.example.prueba.domain.entities.Employee as EmployeeDomain

class EmployeeMappers {

    fun toEmployeeDomain(employee: Employee): EmployeeDomain = EmployeeDomain(
        employee.email,
        employee.name,
        employee.position
    )

    fun toEmployeeData(employeeDomain: EmployeeDomain): Employee = Employee(
        employeeDomain.email,
        employeeDomain.name,
        employeeDomain.position
    )
}