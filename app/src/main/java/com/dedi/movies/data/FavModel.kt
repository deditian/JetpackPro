package com.dedi.movies.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "favorite_table")
data class FavModel(
    @PrimaryKey  @field:SerializedName("id") val idfav: Int,
    @field:SerializedName("titlefav") val titlefav: String,
    @field:SerializedName("imagefav") val imagefav: String,
    @field:SerializedName("overviewfav") val overviewfav: String,
    @field:SerializedName("statusfav") val statusfav: String

):Parcelable
