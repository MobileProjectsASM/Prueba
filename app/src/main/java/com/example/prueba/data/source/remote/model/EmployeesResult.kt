package com.example.prueba.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class EmployeesResult (
    @SerializedName("Error")
    var error : String? = null,
    @SerializedName("Exception")
    var exception : String? = null,
    @SerializedName("Exito")
    var success : String? = null,
    @SerializedName("Mensaje")
    var message : String? = null,
    @SerializedName("Data")
    var employees : ArrayList<Employee> = arrayListOf()
)
