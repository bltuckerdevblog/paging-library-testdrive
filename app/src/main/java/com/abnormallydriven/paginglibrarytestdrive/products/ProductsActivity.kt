package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.abnormallydriven.paginglibrarytestdrive.R
import com.abnormallydriven.paginglibrarytestdrive.common.ViewModelFactory
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import javax.inject.Inject

class ProductsActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    @Inject
    lateinit var productsAdapter: ProductsAdapter

    private lateinit var viewModel: ProductsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products)

        findViewById<RecyclerView>(R.id.products_recycler_view).adapter = productsAdapter

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ProductsViewModel::class.java)


        viewModel.livePagedListOfProducts.observe(this, Observer<PagedList<Product>>{
            productsAdapter.submitList(it)
        })

    }
}
