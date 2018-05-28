package com.abnormallydriven.paginglibrarytestdrive.products

import com.google.gson.annotations.SerializedName


data class ProductsResponseMeta(
        @field:SerializedName("previousPageUrl")
        val previousPageUrl: String,

        @field:SerializedName("nextPageUrl")
        val nextPageUrl: String,

        @field:SerializedName("totalPages")
        val totalPages: Int,

        @field:SerializedName("currentPage")
        val currentPage: Int)