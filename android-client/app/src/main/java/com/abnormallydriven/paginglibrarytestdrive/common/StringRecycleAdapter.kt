package com.abnormallydriven.paginglibrarytestdrive.common

import android.arch.paging.PagedListAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.abnormallydriven.paginglibrarytestdrive.R
import javax.inject.Inject

@ActivityScope
class StringRecycleAdapter @Inject constructor(stringDiffCallback: StringDiffCallback) : PagedListAdapter<String, StringViewHolder>(stringDiffCallback) {
    override fun onBindViewHolder(holder: StringViewHolder, position: Int) {
        val item = getItem(position)
        if (item != null) {
            holder.itemView.findViewById<TextView>(R.id.data_text_view).text = item
        } else {
            holder.itemView.findViewById<TextView>(R.id.data_text_view).text = "Loading..."
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StringViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.my_text_layout, parent, false)

        return StringViewHolder(inflatedView)
    }
}


class StringViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

}
