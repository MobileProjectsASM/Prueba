package com.example.prueba.data.source.remote.model

import com.google.gson.annotations.SerializedName

data class Employee (
    @SerializedName("Correo")
    var email : String? = null,
    @SerializedName("Nombre")
    var name : String? = null,
    @SerializedName("NumEmpleado")
    var noEmployee : String? = null,
    @SerializedName("Puesto")
    var position : String? = null,
    @SerializedName("Vista")
    var visit : String? = null,
    @SerializedName("correoJefe")
    var emailBoss : String? = null,
    @SerializedName("noEmpleadoJefe")
    var noEmployeeBoss : String? = null,
    @SerializedName("nombreJefe")
    var nameBoss : String? = null,
    @SerializedName("puestoJefe")
    var positionBoss : String? = null
)
