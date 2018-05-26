package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.support.v7.util.DiffUtil
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamDiffCallback @Inject constructor() : DiffUtil.ItemCallback<Team>() {

    override fun areItemsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.teamId == newItem.teamId && oldItem.competitionId == newItem.competitionId
    }

    override fun areContentsTheSame(oldItem: Team, newItem: Team): Boolean {
        return oldItem.name == newItem.name && oldItem.crestUrl == newItem.crestUrl && oldItem.shortName == newItem.shortName
    }
}