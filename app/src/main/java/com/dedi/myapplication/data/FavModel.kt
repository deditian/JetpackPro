package com.dedi.myapplication.data

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "fav")
data class FavModel(
    val id: Int,
    @PrimaryKey
    val titlefav: String,
    val imagefav: String,
    val overviewfav: String
){

    @Ignore
    constructor() : this(0, "", "", "")
}