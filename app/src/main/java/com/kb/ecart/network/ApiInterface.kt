package com.kb.ecart.network

import com.kb.ecart.network.model.ProductItemModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("products")
    suspend fun getProdList(): List<ProductItemModel>

    companion object {
        const val BASE_URL = "https://119edbb1-1037-4fa8-bd73-f661b0654ba6.mock.pstmn.io/"
    }

}