package com.abnormallydriven.paginglibrarytestdrive.teamlist

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface DataService {

    @GET("data")
    fun getData(@Query("skip") skip : Int, @Query("limit") limit : Int) : Call<String>

}