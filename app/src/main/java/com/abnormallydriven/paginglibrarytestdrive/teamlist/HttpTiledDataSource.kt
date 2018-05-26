package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.paging.TiledDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HttpTiledDataSource @Inject constructor(private val dataService: DataService) : TiledDataSource<String>() {
    override fun loadRange(startPosition: Int, count: Int): MutableList<String> {
        val response = dataService.getData(startPosition, count).execute()
        val body = response.body()

        val split = body?.split(",")

        return split?.toMutableList() ?: mutableListOf()
    }

    override fun countItems(): Int {
        return 1000
    }
}