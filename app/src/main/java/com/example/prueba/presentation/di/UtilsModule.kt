package com.example.prueba.presentation.di

import android.content.Context
import androidx.room.Room
import com.example.prueba.data.source.local.TestDataBase
import com.example.prueba.data.source.local.mappers.EmployeeMapper
import com.example.prueba.data.source.remote.mappers.EmployeeMapper as EmployeeMapperRemote
import com.example.prueba.data.source.remote.api.ApiServiceClient
import com.example.prueba.data.source.remote.api.ServiceGenerator
import com.example.prueba.data.source.remote.api.ServiceGeneratorImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class UtilsModule {

    @Provides
    fun provideTestDataBase(@ApplicationContext context: Context): TestDataBase = Room.databaseBuilder(
        context,
        TestDataBase::class.java, "test-data-base"
    ).build()

    @Provides
    fun providesServiceGenerator(retrofit: Retrofit): ServiceGenerator<ApiServiceClient> {
        return ServiceGeneratorImpl(retrofit)
    }

    @Provides
    fun providesEmployeeMapperLocal(): EmployeeMapper = EmployeeMapper()

    @Provides
    fun providesEmployeeMapperRemote(): EmployeeMapperRemote = EmployeeMapperRemote()

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://desa.auditoriags.com/ServicioADA_MFRAP/AdaDataService.svc/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}