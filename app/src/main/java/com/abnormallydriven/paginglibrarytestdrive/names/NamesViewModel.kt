package com.abnormallydriven.paginglibrarytestdrive.names

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import javax.inject.Inject

class NamesViewModel @Inject constructor(private val dataSourceFactory: NamesDataSourceFactory) : ViewModel() {

    val livePagedListOfNames: LiveData<PagedList<String>>

    init {

        val pagedListConfig = PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setInitialLoadSizeHint(30)
                .setPageSize(10)
                .build()


        livePagedListOfNames = LivePagedListBuilder(dataSourceFactory, pagedListConfig)
                .build()
    }

}