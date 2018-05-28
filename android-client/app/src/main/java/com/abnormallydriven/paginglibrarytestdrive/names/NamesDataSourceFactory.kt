package com.abnormallydriven.paginglibrarytestdrive.names

import android.arch.paging.DataSource
import javax.inject.Inject

class NamesDataSourceFactory @Inject constructor(private val namesApi: NamesApi) : DataSource.Factory<String, String>() {

    override fun create(): DataSource<String, String> {
        return NamesDataSource(namesApi)
    }

}