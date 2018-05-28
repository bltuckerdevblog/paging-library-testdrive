package com.abnormallydriven.paginglibrarytestdrive.products

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import dagger.Lazy
import javax.inject.Inject

class ProductsViewModel @Inject constructor(private val productsDataSourceFactory: ProductsDataSourceFactory) : ViewModel() {

    val livePagedListOfProducts: LiveData<PagedList<Product>>

    init {
        livePagedListOfProducts = LivePagedListBuilder(productsDataSourceFactory, 10).build()
    }
}