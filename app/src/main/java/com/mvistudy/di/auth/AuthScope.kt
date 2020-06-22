package com.mvistudy.di.auth

import javax.inject.Scope

/**
 * @author Udit Roy
 * AuthScope is strictly for login and registration
 */
@Scope
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AuthScope