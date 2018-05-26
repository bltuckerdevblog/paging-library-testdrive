package com.abnormallydriven.paginglibrarytestdrive.common

import android.support.v7.util.DiffUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StringDiffCallback @Inject constructor() : DiffUtil.ItemCallback<String>() {
    override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {

        if(oldItem == null || newItem == null){
            return false
        }

        return oldItem.equals(newItem)
    }

    override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {

        if(oldItem == null || newItem == null){
            return false
        }

        return oldItem.equals(newItem)
    }
}