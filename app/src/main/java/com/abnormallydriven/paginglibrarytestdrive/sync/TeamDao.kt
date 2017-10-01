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
    fun insertTeam(team: Team)

    @Query("SELECT * FROM teams order by name ASC")
    fun getTeamsAsLivePagedListProvider(): LivePagedListProvider<Int, Team>

    @Query("SELECT * FROM teams WHERE teamId >= :teamId order by name ASC")
    fun getTeamsAsTiledDataSource(teamId: Int): TiledDataSource<Team>

    @Query("SELECT * FROM teams order by name ASC LIMIT :limit OFFSET :offset")
    fun getTeamsArray(offset: Int, limit: Int): Array<Team>

    @Query("SELECT * FROM teams order by name ASC")
    fun getAllTeams(): Array<Team>

    @Query("SELECT COUNT(*) FROM teams")
    fun getTeamCount(): Int

    //For Keyed Datasources
    @Query("SELECT * FROM teams ORDER BY name DESC LIMIT :limit")
    fun getInitialData(limit: Int): Array<Team>

    @Query("SELECT * FROM teams WHERE name < :name ORDER BY name DESC LIMIT :limit")
    fun getDataAfterName(name: String, limit: Int): Array<Team>

    @Query("SELECT * FROM teams where name > :name ORDER BY name ASC LIMIT :limit")
    fun getDataBeforeName(name: String, limit: Int): Array<Team>


}