package com.zuh.central.datasource.model

import com.google.gson.annotations.SerializedName

data class CatFactsResModel (
    @SerializedName("text")
    var fact: String? = null
)
