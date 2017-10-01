package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.core.executor.AppToolkitTaskExecutor
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.sync.DataSyncer
import dagger.android.AndroidInjection
import javax.inject.Inject

class TeamListActivity : AppCompatActivity() {

    @Inject lateinit var dataSyncer: DataSyncer

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var teamAdapter: TeamListAdapter

    lateinit var viewModel: TeamsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team_list)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TeamsViewModel::class.java)

        lifecycle.addObserver(dataSyncer)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = teamAdapter


        //
        //Use the LivePagedListProvider Query
//        viewModel.userListLiveData.observe(this, Observer(teamAdapter::setList))


        //
        //Use The Tiled Data Source
//        AppToolkitTaskExecutor.getIOThreadExecutor()
//                .execute({
//
//                    val pagedListConfig = PagedList.Config.Builder()
//                            .setPageSize(20)
//                            .setPrefetchDistance(20)
//                            .build()
//
//                    val pagedList: PagedList<Team> = PagedList.Builder<Int, Team>()
//                            .setInitialKey(100)
//                            .setConfig(pagedListConfig)
//                            .setDataSource(viewModel.tiledDataSource)
//                            .setMainThreadExecutor(AppToolkitTaskExecutor.getMainThreadExecutor())
//                            .setBackgroundThreadExecutor(AppToolkitTaskExecutor.getIOThreadExecutor())
//                            .build()
//
//                    AppToolkitTaskExecutor.getMainThreadExecutor()
//                            .execute { teamAdapter.setList(pagedList) }
//
//                })

        //
        //Custom tiled datasource
//        AppToolkitTaskExecutor.getIOThreadExecutor()
//                .execute({
//
//                    val pagedListConfig = PagedList.Config.Builder()
//                            .setPageSize(20)
//                            .setPrefetchDistance(20)
//                            .build()
//
//                    val pagedList: PagedList<Team> = PagedList.Builder<Int, Team>()
//                            .setInitialKey(0)
//                            .setConfig(pagedListConfig)
//                            .setDataSource(viewModel.teamDataSource)
//                            .setMainThreadExecutor(AppToolkitTaskExecutor.getMainThreadExecutor())
//                            .setBackgroundThreadExecutor(AppToolkitTaskExecutor.getIOThreadExecutor())
//                            .build()
//
//                    AppToolkitTaskExecutor.getMainThreadExecutor()
//                            .execute { teamAdapter.setList(pagedList) }
//
//
//                })


        //
        //Keyed data source
                AppToolkitTaskExecutor.getIOThreadExecutor()
                .execute({

                    val pagedListConfig = PagedList.Config.Builder()
                            .setPageSize(20)
                            .setPrefetchDistance(20)
                            .build()

                    val pagedList: PagedList<Team> = PagedList.Builder<String, Team>()
                            .setInitialKey("Arsenal FC")
                            .setConfig(pagedListConfig)
                            .setDataSource(viewModel.keyedTeamDataSource)
                            .setMainThreadExecutor(AppToolkitTaskExecutor.getMainThreadExecutor())
                            .setBackgroundThreadExecutor(AppToolkitTaskExecutor.getIOThreadExecutor())
                            .build()

                    AppToolkitTaskExecutor.getMainThreadExecutor()
                            .execute { teamAdapter.setList(pagedList) }


                })

    }
}
