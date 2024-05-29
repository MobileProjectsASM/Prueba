package com.example.prueba.data.source.remote

import com.example.prueba.domain.entities.Employee

interface EmployeeRemoteSource {
    suspend fun getEmployeesByAuditoryAndCriterion(auditory: String, criterion: String): List<Employee>
}