package com.example.prueba.domain.entities

import com.example.prueba.data.source.local.entities.Employee

sealed class EmployeeResponse {
    data object Successful: EmployeeResponse()
    data class Error(val message: String): EmployeeResponse()
}