package com.abnormallydriven.paginglibrarytestdrive.sync

import com.abnormallydriven.paginglibrarytestdrive.sync.CompetitionDto
import com.abnormallydriven.paginglibrarytestdrive.teamlist.TeamListResponse
import retrofit2.http.GET
import retrofit2.http.Headers


interface FootballApi {

    @GET("competitions")
    @Headers("X-Response-Control", "minified")
    fun getCompetitionList() : List<CompetitionDto>

    @GET("competitions/{competitionId}/teams")
    @Headers("X-Response-Control", "minified")
    fun getCompetitionTeamList(competitionId: Int): TeamListResponse

}