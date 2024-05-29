package com.example.prueba.data.source.remote

import com.example.prueba.domain.entities.Employee

interface EmployeeRemoteSource {
    suspend fun getEmployees(): List<Employee>
}