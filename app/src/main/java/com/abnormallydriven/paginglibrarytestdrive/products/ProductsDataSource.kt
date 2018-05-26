package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.paging.PageKeyedDataSource

class ProductsDataSource constructor(private val productsApi: ProductsApi,
                                     private val searchTerm: String) : PageKeyedDataSource<String, Product>() {

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, Product>) {

        val productsResponse = productsApi.searchProducts(searchTerm, 1).execute()
        val nextPageUrl = productsResponse.body()?.meta?.nextPageUrl ?: null
        val products = productsResponse.body()?.products ?: listOf()

        callback.onResult(products, null, nextPageUrl)
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, Product>) {
        val productsResponse = productsApi.getPageOfResults(params.key).execute()

        val nextPageUrl = productsResponse.body()?.meta?.nextPageUrl ?: null
        val products = productsResponse.body()?.products ?: listOf()

        callback.onResult(products, nextPageUrl)
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String, Product>) {
        //meh
    }
}