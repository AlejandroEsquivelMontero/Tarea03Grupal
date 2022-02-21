package com.example.tarea01guarga_links.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="Links")

class Links (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="URL")
    val URL: String?,
    @ColumnInfo(name="rutaImagen")
    val rutaImagen: String?
) : Parcelable