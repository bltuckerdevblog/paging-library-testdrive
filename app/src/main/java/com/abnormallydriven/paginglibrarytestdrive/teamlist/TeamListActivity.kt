package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.lifecycle.ViewModelProvider
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.common.StringRecycleAdapter
import com.abnormallydriven.paginglibrarytestdrive.sync.DataSyncer
import dagger.android.AndroidInjection
import javax.inject.Inject

class TeamListActivity : AppCompatActivity() {

    @Inject lateinit var dataSyncer: DataSyncer

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var stringRecyclerAdapter : StringRecycleAdapter

    lateinit var viewModel: TeamsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)
//
//        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamsViewModel::class.java)
//
//        lifecycle.addObserver(dataSyncer)
//
//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
