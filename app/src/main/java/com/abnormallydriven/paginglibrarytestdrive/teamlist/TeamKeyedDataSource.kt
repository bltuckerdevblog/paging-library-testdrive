package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.paging.KeyedDataSource
import android.arch.persistence.room.InvalidationTracker
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDao
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDatabase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamKeyedDataSource @Inject constructor(
        private val teamDatabase: TeamDatabase,
        private val teamDao: TeamDao) : KeyedDataSource<String, Team>() {

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

    override fun loadBefore(currentBeginKey: String, pageSize: Int): MutableList<Team> {
        return teamDao.getDataBeforeName(currentBeginKey, pageSize).toMutableList()
    }

    override fun loadInitial(pageSize: Int): MutableList<Team> {
        return teamDao.getInitialData(pageSize).toMutableList()
    }

    override fun loadAfter(currentEndKey: String, pageSize: Int): MutableList<Team> {
        return teamDao.getDataAfterName(currentEndKey, pageSize).toMutableList()
    }

    override fun getKey(item: Team): String {
        return item.name
    }
}