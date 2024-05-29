package com.example.prueba.domain.uc

import com.example.prueba.domain.entities.EmployeeResponse
import com.example.prueba.domain.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class SyncEmployeesUc @Inject constructor(
    val repository: EmployeeRepository
) {
    companion object {
        const val AUDIT_ID = "312618"
        const val CRITERION = "Gilberto Medina Castro"
    }
    suspend fun syncEmployees(): EmployeeResponse = withContext(Dispatchers.IO) {
        try {
            repository.syncEmployees(AUDIT_ID, CRITERION)
            return@withContext EmployeeResponse.Successful
        } catch (exception: Exception) {
            return@withContext EmployeeResponse.Error(exception.message ?: "Error Unknown")
        }
    }
}