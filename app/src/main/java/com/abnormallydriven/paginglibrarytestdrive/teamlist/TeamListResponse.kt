package com.abnormallydriven.paginglibrarytestdrive.teamlist

import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDto
import com.google.gson.annotations.SerializedName

data class TeamListResponse(

        @field:SerializedName("teams")
	val teams: List<TeamDto?>? = null,

        @field:SerializedName("count")
	val count: Int? = null
)