package com.kb.ecart.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kb.ecart.network.ProductRepository
import com.kb.ecart.network.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val productRepository: ProductRepository, ) : ViewModel() {

    private var productListState = MutableStateFlow(HomescreenState())
    val homeScreenState = productListState.asStateFlow()

    init {
        getProductList()
    }

    private fun getProductList() {
        viewModelScope.launch {
            productListState.update {
                it.copy(isLoading = true)
            }

            productRepository.getProductList().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        productListState.update {
                            it.copy(isLoading = false)
                        }
                    }

                    is Resource.Success -> {
                        result.data?.let { itemList ->
                            productListState.update {
                                it.copy(
                                    productList = itemList,
                                )
                            }
                        }
                    }

                    is Resource.Loading -> {
                        productListState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }
                }
            }
        }
    }
}