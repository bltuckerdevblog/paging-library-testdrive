package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListProvider
import android.arch.paging.PagedList
import android.arch.paging.TiledDataSource

import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDao

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsViewModel @Inject
constructor(private val teamDao: TeamDao) : ViewModel(){

    val userListLiveData : LiveData<PagedList<Team>>

    val tiledDataSource : TiledDataSource<Team>

    init{
        val pagedListConfig = PagedList.Config.Builder()
                .setPageSize(20)
                .setPrefetchDistance(20)
                .build()

        userListLiveData = teamDao.getTeamsAsLivePagedListProvider().create(0, pagedListConfig)
        tiledDataSource = teamDao.getTeamsAsTiledDataSource()

    }





}
