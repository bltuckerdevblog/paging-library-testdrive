package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.abnormallydriven.paginglibrarytestdrive.teamlist.sync.TeamDao
import javax.inject.Inject

class TeamsViewModel @Inject
constructor(private val teamDao: TeamDao) : ViewModel(){

    val liveTeamData: LiveData<PagedList<Team>>

    init {

        val teamsByNameDataSourceFactory = teamDao.loadTeamsByName()

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(10)
                .setPageSize(10)
                .build()

        liveTeamData = LivePagedListBuilder(teamsByNameDataSourceFactory, pagedListConfig).build()
    }

}
