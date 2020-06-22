package com.mvistudy.di.auth

import com.mvistudy.api.auth.OpenAuthApiService
import com.mvistudy.persistence.AccountPropertiesDao
import com.mvistudy.persistence.AuthTokenDao
import com.mvistudy.repository.auth.AuthRepository
import com.mvistudy.session.SessionManager
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class AuthModule {

    @AuthScope
    @Provides
    fun provideFakeApiService(retrofitBuilder: Retrofit.Builder): OpenAuthApiService {
        return retrofitBuilder.build().create(OpenAuthApiService::class.java)
    }

    @AuthScope
    @Provides
    fun provideAuthRepository(
        sessionManager: SessionManager,
        authTokenDao: AuthTokenDao,
        accountPropertiesDao: AccountPropertiesDao,
        openApiAuthService: OpenAuthApiService
    ): AuthRepository {
        return AuthRepository(
            authTokenDao,
            accountPropertiesDao,
            openApiAuthService,
            sessionManager
        )
    }

}