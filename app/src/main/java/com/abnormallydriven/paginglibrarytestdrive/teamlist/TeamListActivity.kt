package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.sync.DataSyncer
import dagger.android.AndroidInjection
import javax.inject.Inject

class TeamListActivity : AppCompatActivity() {

    @Inject lateinit var dataSyncer : DataSyncer

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        lifecycle.addObserver(dataSyncer)

    }
}
