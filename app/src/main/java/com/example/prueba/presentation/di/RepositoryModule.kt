package com.example.prueba.presentation.di

import com.example.prueba.data.repository.EmployeeRepositoryImpl
import com.example.prueba.domain.repository.EmployeeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun getEmployeeRepository(employeeRepositoryImpl: EmployeeRepositoryImpl): EmployeeRepository
}