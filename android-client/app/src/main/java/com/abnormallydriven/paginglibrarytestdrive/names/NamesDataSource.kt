package com.abnormallydriven.paginglibrarytestdrive.names

import android.arch.paging.ItemKeyedDataSource
import javax.inject.Inject
import javax.inject.Singleton

class NamesDataSource constructor(private val namesApi: NamesApi) : ItemKeyedDataSource<String, String>() {

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String>) {
        val response = namesApi.getNamesAfter("", params.requestedLoadSize).execute()

        val responseData = response.body()?.toList() ?: listOf()
        callback.onResult(responseData)
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String>) {
        val response = namesApi.getNamesAfter(params.key, params.requestedLoadSize).execute()

        val responseData = response.body()?.toList() ?: listOf()
        callback.onResult(responseData)
    }

    override fun loadBefore(params: LoadParams<String>, callback: LoadCallback<String>) {

    }

    override fun getKey(item: String) = item
}