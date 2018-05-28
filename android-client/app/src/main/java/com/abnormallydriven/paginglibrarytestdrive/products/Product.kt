package com.abnormallydriven.paginglibrarytestdrive.products

import com.google.gson.annotations.SerializedName


class Product(@field:SerializedName("product_name")
              val name: String,

              @field:SerializedName("price")
              val price: String,

              @field:SerializedName("id")
              val id: String)