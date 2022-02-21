package com.example.tarea01guarga_links.ui.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.tarea01guarga_links.model.Links
import com.example.tarea01guarga_links.model.LinksDataBase
import com.example.tarea01guarga_links.repository.LinksRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LinksViewModel (application: Application) : AndroidViewModel(application) {
    val getAllData: LiveData<List<Links>>

    private val repository: LinksRepository

    init {
        val linksDao = LinksDataBase.getDataBase(application).linksDao()
        repository = LinksRepository(linksDao)
        getAllData = repository.getAllData
    }



    fun addLinks (links: Links){
        viewModelScope.launch(Dispatchers.IO) { repository.addLink(links) }
    }

    fun updateLinks (links: Links){
        viewModelScope.launch(Dispatchers.IO) { repository.updateLink(links) }
    }

    fun deleteLinks (links: Links){
        viewModelScope.launch(Dispatchers.IO) { repository.deleteLink(links) }
    }



}