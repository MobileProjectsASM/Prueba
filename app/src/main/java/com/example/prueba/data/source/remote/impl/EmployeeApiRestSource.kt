package com.example.prueba.data.source.remote.impl

import com.example.prueba.data.source.remote.EmployeeRemoteSource
import com.example.prueba.data.source.remote.api.ApiServiceClient
import com.example.prueba.data.source.remote.api.ServiceGenerator
import com.example.prueba.data.source.remote.errors.ApiError
import com.example.prueba.data.source.remote.mappers.EmployeeMapper
import com.example.prueba.domain.entities.Employee
import javax.inject.Inject

class EmployeeApiRestSource @Inject constructor(
    val serviceGenerator: ServiceGenerator<ApiServiceClient>,
    val employeeMapper: EmployeeMapper
): EmployeeRemoteSource {

    override suspend fun getEmployeesByAuditoryAndCriterion(auditory: String, criterion: String): List<Employee> {
        val response = serviceGenerator.getService(ApiServiceClient::class.java).getEmployees(auditory, criterion)
        if (response.error != null && response.error!!.isNotEmpty()) {
            throw ApiError(response.error!!)
        }
        if (response.exception != null && response.exception!!.isNotEmpty()) {
            throw ApiError(response.exception!!)
        }
        if (response.success == null || response.success != "true") {
            throw ApiError("Error unknown")
        }
        return response.employees.map(employeeMapper::toEmployee)
    }
}