package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.paging.DataSource
import javax.inject.Inject

class ProductsDataSourceFactory @Inject constructor(private val productsApi: ProductsApi,
                                                    private val searchTerm: String) : DataSource.Factory<String, Product>() {
    override fun create(): DataSource<String, Product> {
        return ProductsDataSource(productsApi, searchTerm)
    }

}
