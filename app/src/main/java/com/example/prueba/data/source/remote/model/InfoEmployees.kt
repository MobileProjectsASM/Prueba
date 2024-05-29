package com.example.prueba.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class InfoEmployees (
    @SerializedName("GetEmpleadosAdaResult" ) var infoEmployees : EmployeesResult? = EmployeesResult()
)
