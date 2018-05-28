package com.abnormallydriven.paginglibrarytestdrive.products

import android.support.v7.util.DiffUtil
import javax.inject.Inject

class ProductDiffer @Inject constructor() : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product?, newItem: Product?): Boolean {
        return oldItem?.id == oldItem?.id
    }

    override fun areContentsTheSame(oldItem: Product?, newItem: Product?): Boolean {
        return oldItem?.name == newItem?.name && oldItem?.price == newItem?.price
    }
}