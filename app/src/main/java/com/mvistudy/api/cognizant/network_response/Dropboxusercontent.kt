package com.mvistudy.api.cognizant.network_response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Dropboxusercontent(

    @SerializedName("title")
    @Expose
    val title: String,

    @SerializedName("rows")
    @Expose
    val rows: List<Rows>
) {
    override fun toString(): String {
        return "BlogListSearchResponse(results=$rows, detail='$title')"
    }
}