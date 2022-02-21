package com.example.tarea01guarga_links.model

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarea01guarga_links.data.LinksDao

@Database(entities = [Links::class], version = 1, exportSchema = false)

abstract class LinksDataBase: RoomDatabase() {
    abstract fun linksDao() : LinksDao

    companion object{
        @Volatile
        private var INSTACE: LinksDataBase? = null

        fun getDataBase(context: android.content.Context) : LinksDataBase {
            val tempInstance = INSTACE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    LinksDataBase::class.java,
                    "link_database"
                ).build()
                INSTACE=instance
                return instance
            }
        }
    }
}