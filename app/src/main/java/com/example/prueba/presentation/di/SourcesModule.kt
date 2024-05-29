package com.example.prueba.presentation.di

import com.example.prueba.data.source.hardware.ConnectionImpl
import com.example.prueba.data.source.hardware.Connections
import com.example.prueba.data.source.local.impl.EmployeeRoomSource
import com.example.prueba.data.source.local.interfaces.EmployeeLocalSource
import com.example.prueba.data.source.remote.EmployeeRemoteSource
import com.example.prueba.data.source.remote.impl.EmployeeApiRestSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SourcesModule {

    @Binds
    abstract fun getEmployeeLocalSource(employeeRoomSource: EmployeeRoomSource): EmployeeLocalSource

    @Binds
    abstract fun getEmployeeRemoteSource(employeeApiRestSource: EmployeeApiRestSource): EmployeeRemoteSource

    @Binds
    abstract fun getConnections(connectionImpl: ConnectionImpl): Connections
}