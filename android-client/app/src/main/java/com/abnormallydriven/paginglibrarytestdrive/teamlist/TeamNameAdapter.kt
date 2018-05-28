package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.paging.PagedList
import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.abnormallydriven.paginglibrarytestdrive.R
import javax.inject.Inject


class TeamNameAdapter @Inject constructor(teamDiffCallback: TeamDiffCallback) : PagedListAdapter<Team, TeamViewHolder>(teamDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return TeamViewHolder(layoutInflater.inflate(R.layout.team_view_item, parent,false))
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val safeTeam = getItem(position) ?: return
        holder.bind(safeTeam)
    }
}