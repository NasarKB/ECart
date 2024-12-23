package com.kb.ecart.network

import com.kb.ecart.network.model.ProductItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiInterface: ApiInterface,
) : ProductRepository {
    override suspend fun getProductList(): Flow<Resource<List<ProductItemModel>>> {
        return flow {

            emit(Resource.Loading(true))
            val prodListFromApi = try {
                apiInterface.getProdList()
            } catch (e: IOException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            } catch (e: HttpException) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(Resource.Error(message = "Error loading movies"))
                return@flow
            }

            emit(Resource.Success(prodListFromApi))
            emit(Resource.Loading(false))
        }
    }
}