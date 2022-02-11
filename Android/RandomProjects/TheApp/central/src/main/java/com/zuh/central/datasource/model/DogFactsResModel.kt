package com.zuh.central.datasource.model

import com.google.gson.annotations.SerializedName

data class DogFactsResModel (
    @SerializedName("text")
    var fact: String? = null
)