package com.mvistudy.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cognizant_post")
data class CognizantPost(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pk")
    var pk: Int,

    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "description")
    val description: String,

    @ColumnInfo(name = "imageHref")
    val imageHref: String

) {

    override fun toString(): String {
        return "CognizantPost(pk=$pk, " +
                "title='$title', " +
                "description='$description', " +
                "imageHref='$imageHref')"
    }


}