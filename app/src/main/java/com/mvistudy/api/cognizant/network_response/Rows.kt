package com.mvistudy.api.cognizant.network_response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Rows(

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("description")
    @Expose
    val description: String,

    @SerializedName("imageHref")
    @Expose
    val imageHref: String
) {
    override fun toString(): String {
        return "BlogRowResponse(title=$title, description='$description',imageHref='$imageHref')"
    }
}