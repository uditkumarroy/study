package com.mvistudy.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mvistudy.models.AccountProperties
import com.mvistudy.models.AuthToken
import com.mvistudy.models.CognizantPost

@Database(
    entities = [AuthToken::class, AccountProperties::class, CognizantPost::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getAuthTokenDao(): AuthTokenDao

    abstract fun getAccountPropertiesDao(): AccountPropertiesDao

    abstract fun getCognizantDao(): CognizantDao

    companion object {
        val DATABASE_NAME: String = "app_db"
    }


}