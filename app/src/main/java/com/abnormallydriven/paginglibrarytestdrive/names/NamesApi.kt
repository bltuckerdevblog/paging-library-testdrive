package com.abnormallydriven.paginglibrarytestdrive.names

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NamesApi {

    @GET("names")
    fun getNamesAfter(@Query("after") afterName : String, @Query("limit") limit: Int) : Call<Array<String>>
}