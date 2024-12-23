package com.kb.ecart.network.di
import com.kb.ecart.network.ProductRepository
import com.kb.ecart.network.ProductRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindProductListRepository(
        productListRepositoryImpl: ProductRepositoryImpl
    ): ProductRepository

}