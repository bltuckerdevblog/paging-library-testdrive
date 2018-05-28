package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "teams", primaryKeys = arrayOf("competitionId", "teamId"))
data class Team (
        val competitionId: Int,
        val teamId : Int,
        val name : String,
        val shortName : String,
        val crestUrl : String
)