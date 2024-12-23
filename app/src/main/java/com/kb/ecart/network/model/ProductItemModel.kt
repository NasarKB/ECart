package com.kb.ecart.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ProductItemModel(
    @Expose @SerializedName("id") var id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("price") var price: Int,
    @SerializedName("image") var image: String)