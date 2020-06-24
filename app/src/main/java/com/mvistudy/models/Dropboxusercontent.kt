package com.mvistudy.models

import com.google.gson.annotations.SerializedName

data class Dropboxusercontent(

    @SerializedName("title") val title: String,
    @SerializedName("rows") val rows: List<Rows>
)