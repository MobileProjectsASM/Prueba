package com.example.prueba.data.source.remote.api

import retrofit2.Retrofit
interface ServiceGenerator<T> {
    val retrofit: Retrofit?
    fun getService(serviceClass: Class<T>): T
}
