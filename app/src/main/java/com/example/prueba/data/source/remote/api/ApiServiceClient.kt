package com.example.prueba.data.source.remote.api

import com.example.prueba.data.source.remote.model.EmployeesResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceClient {
    @GET("GetEmpleadosAda")
    suspend fun getEmployees(@Query("idAuditoria") idAuditory: String, @Query("criterio") criterion: String): EmployeesResult
}