package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.abnormallydriven.paginglibrarytestdrive.R

class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    lateinit var teamNameTextView : TextView

    init{
        teamNameTextView = itemView.findViewById(R.id.team_name_text_view)
    }


    fun bind(team : Team){

        teamNameTextView.text = team.name



    }

}