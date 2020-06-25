package com.mvistudy.persistence

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mvistudy.models.CognizantPost

@Dao
interface CognizantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cognizantPost: CognizantPost): Long

    @Query("SELECT * FROM cognizant_post")
    fun getAllPosts(): LiveData<List<CognizantPost>>
}