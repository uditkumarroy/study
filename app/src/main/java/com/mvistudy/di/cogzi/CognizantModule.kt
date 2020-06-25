package com.mvistudy.di.cogzi

import com.mvistudy.api.cognizant.OpenCognizantApiService
import com.mvistudy.persistence.AppDatabase
import com.mvistudy.persistence.CognizantDao
import com.mvistudy.repository.cognizant.CognizantRepository
import com.mvistudy.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class CognizantModule {

    @CogziScope
    @Provides
    fun provideFakeApiService(retrofitBuilder: Retrofit.Builder): OpenCognizantApiService {
        return retrofitBuilder.build().create(OpenCognizantApiService::class.java)
    }

    @CogziScope
    @Provides
    fun provideCogziDao(db: AppDatabase): CognizantDao {
        return db.getCognizantDao()
    }

    @CogziScope
    @Provides
    fun provideCogziRepository(
        openCognizantApiService: OpenCognizantApiService,
        sessionManager: SessionManager,
        cognizantDao: CognizantDao
    ): CognizantRepository {
        return CognizantRepository(openCognizantApiService, sessionManager, cognizantDao)
    }
}