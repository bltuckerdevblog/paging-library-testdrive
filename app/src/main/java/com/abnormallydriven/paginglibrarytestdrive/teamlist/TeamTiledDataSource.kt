package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.paging.TiledDataSource
import android.arch.persistence.room.InvalidationTracker
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDao
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDatabase
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class TeamTiledDataSource @Inject constructor(
        private val teamDatabase : TeamDatabase,
        private val teamDao : TeamDao
) : TiledDataSource<Team>() {

    val invalidationObserver : InvalidationTracker.Observer


    init {
        invalidationObserver =
                object : InvalidationTracker.Observer("teams") {
                    override fun onInvalidated(tables: MutableSet<String>) {
                        invalidate()
                    }

                }
        teamDatabase.invalidationTracker.addObserver(invalidationObserver)
    }


    override fun countItems(): Int = teamDao.getTeamCount()

    override fun loadRange(startPosition: Int, count: Int): MutableList<Team> {
        return teamDao.getTeamsArray(startPosition, count).toMutableList()
    }
}