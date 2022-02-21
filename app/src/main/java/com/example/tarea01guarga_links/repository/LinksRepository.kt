package com.example.tarea01guarga_links.repository

import androidx.lifecycle.LiveData
import com.example.tarea01guarga_links.data.LinksDao
import com.example.tarea01guarga_links.model.Links

class LinksRepository(private val linkDao: LinksDao) {
    val getAllData: LiveData<List<Links>> = linkDao.getAllData()

    suspend fun addLink(link: Links){
        linkDao.addLinks(link)
    }

    suspend fun updateLink(link: Links){
        linkDao.updateLinks(link)
    }

    suspend fun deleteLink(link: Links){
        linkDao.deleteLinks(link)
    }

}