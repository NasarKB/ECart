package com.kb.ecart.screens.home_screen

import com.kb.ecart.network.model.ProductItemModel

data class HomescreenState(
    val isLoading: Boolean = false,
    val productList: List<ProductItemModel> = emptyList(),
)