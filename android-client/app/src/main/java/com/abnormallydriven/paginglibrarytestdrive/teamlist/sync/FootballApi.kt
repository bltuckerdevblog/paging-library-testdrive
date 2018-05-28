package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import com.abnormallydriven.paginglibrarytestdrive.teamlist.TeamListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path


interface FootballApi {

    @GET("competitions")
    @Headers("X-Response-Control: minified")
    fun getCompetitionList() : Call<List<CompetitionDto>>

    @GET("competitions/{competitionId}/teams")
    @Headers("X-Response-Control: minified")
    fun getCompetitionTeamList(@Path("competitionId") competitionId: Int): Call<TeamListResponse>

}