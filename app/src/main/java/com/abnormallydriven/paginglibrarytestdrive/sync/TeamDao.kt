package com.abnormallydriven.paginglibrarytestdrive.sync

import android.arch.paging.LivePagedListProvider
import android.arch.paging.TiledDataSource
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.abnormallydriven.paginglibrarytestdrive.teamlist.Team

@Dao
interface TeamDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeam(team : Team)

    @Query("SELECT * FROM teams order by name ASC")
    fun getTeamsAsLivePagedListProvider(): LivePagedListProvider<Int, Team>

    @Query("SELECT * FROM teams order by name ASC")
    fun getTeamsAsTiledDataSource() : TiledDataSource<Team>

    @Query("SELECT * FROM teams order by name ASC LIMIT 10 OFFSET :offset")
    fun getTeamsArray(offset : Int) : Array<Team>

    @Query("SELECT * FROM teams order by name ASC")
    fun getAllTeams() : Array<Team>

}