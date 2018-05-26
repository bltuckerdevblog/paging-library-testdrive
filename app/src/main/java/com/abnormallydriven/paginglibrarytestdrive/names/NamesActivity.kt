package com.abnormallydriven.paginglibrarytestdrive.names

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.common.StringRecycleAdapter
import com.abnormallydriven.paginglibrarytestdrive.common.ViewModelFactory
import dagger.android.AndroidInjection
import javax.inject.Inject

class NamesActivity : AppCompatActivity() {

    @Inject
    lateinit var stringsAdapter: StringRecycleAdapter

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var viewModel: NamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_names)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(NamesViewModel::class.java)

        findViewById<RecyclerView>(R.id.names_recycler_view).adapter = stringsAdapter

        viewModel.livePagedListOfNames.observe(this, Observer<PagedList<String>>{
            stringsAdapter.submitList(it)
        })
    }
}
