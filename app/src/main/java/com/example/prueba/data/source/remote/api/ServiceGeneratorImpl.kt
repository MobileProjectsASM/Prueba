package com.example.prueba.data.source.remote.api

import retrofit2.Retrofit

class ServiceGeneratorImpl<T>(override val retrofit: Retrofit) : ServiceGenerator<T> {
    private var service: T? = null

    override fun getService(serviceClass: Class<T>): T {
        if (service == null) service = retrofit.create(serviceClass)
        return service!!
    }
}
