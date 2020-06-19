package com.mvistudy.session

import android.app.Application
import com.mvistudy.persistence.AuthTokenDao

class SessionManager constructor(val authTokenDao: AuthTokenDao, val application: Application)