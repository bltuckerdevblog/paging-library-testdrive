package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.teamlist.sync.DataSyncer
import dagger.android.AndroidInjection
import javax.inject.Inject

class TeamListActivity : AppCompatActivity() {

    @Inject lateinit var dataSyncer: DataSyncer

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var teamNameAdapter : TeamNameAdapter

    lateinit var viewModel: TeamsViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamsViewModel::class.java)
        lifecycle.addObserver(dataSyncer)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = teamNameAdapter

        viewModel.liveTeamData.observe(this, Observer<PagedList<Team>>{
            teamNameAdapter.submitList(it)
        })
    }
}
