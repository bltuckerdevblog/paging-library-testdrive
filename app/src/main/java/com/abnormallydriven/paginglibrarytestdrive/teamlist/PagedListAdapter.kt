package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.abnormallydriven.paginglibrarytestdrive.ActivityScope
import com.abnormallydriven.paginglibrarytestdrive.R
import javax.inject.Inject

@ActivityScope
class TeamListAdapter @Inject constructor(teamDiffCallback: TeamDiffCallback) : PagedListAdapter<Team, TeamViewHolder>(teamDiffCallback) {


    override fun onBindViewHolder(holder: TeamViewHolder?, position: Int) {
        if (holder != null && position < itemCount) {
            getItem(position)?.let { holder.bind(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent!!.context)
        val teamItemView = layoutInflater.inflate(R.layout.team_view_item, parent, false)
        return TeamViewHolder(teamItemView)
    }


}
