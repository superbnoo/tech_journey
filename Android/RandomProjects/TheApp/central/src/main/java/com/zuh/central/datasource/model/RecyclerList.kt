package com.zuh.central.datasource.model

import com.google.gson.annotations.SerializedName

data class RecyclerList(
    @SerializedName("items")
    val items: List<RecyclerData>
)
data class RecyclerData(
    @SerializedName("name")
    val name: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("owner")
    val owner: Owner?
)
data class Owner(
    @SerializedName("avatar_url")
    val avatar_url: String?
)