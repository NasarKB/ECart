package com.kb.ecart.network

import com.kb.ecart.network.model.ProductItemModel
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun getProductList(): Flow<Resource<List<ProductItemModel>>>
}