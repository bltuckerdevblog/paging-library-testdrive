package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import android.arch.paging.DataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.abnormallydriven.paginglibrarytestdrive.teamlist.Team

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team: Team)

    @Query("SELECT * FROM teams order by name ASC")
    fun loadTeamsByName() : DataSource.Factory<Integer, Team>
}