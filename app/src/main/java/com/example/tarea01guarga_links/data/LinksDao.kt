package com.example.tarea01guarga_links.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tarea01guarga_links.model.Links

@Dao

interface LinksDao {
    @Query("SELECT * FROM Links")
    fun getAllData() : LiveData<List<Links>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLinks(link: Links)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateLinks(link: Links)

    @Delete
    suspend fun deleteLinks(link: Links)
}