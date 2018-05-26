package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import com.google.gson.annotations.SerializedName

data class TeamDto(

	@field:SerializedName("squadMarketValue")
	val squadMarketValue: Any? = null,

	@field:SerializedName("crestUrl")
	val crestUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,

	@field:SerializedName("shortName")
	val shortName: String? = null
)