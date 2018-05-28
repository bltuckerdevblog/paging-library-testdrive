package com.abnormallydriven.paginglibrarytestdrive.products

import com.google.gson.annotations.SerializedName


data class ProductsResponse(
        @field:SerializedName("meta")
        var meta: ProductsResponseMeta,

        @field:SerializedName("products")
        val products: List<Product>)