package com.abnormallydriven.paginglibrarytestdrive.products

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ProductsApi {

    @GET("products")//TODO
    fun searchProducts(@Query("searchTerm") searchTerm: String, @Query("page") page: Int) : Call<ProductsResponse>

    @GET
    fun getPageOfResults(@Url nextPageUrl: String) : Call<ProductsResponse>
}