package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import android.content.Intent
import android.support.v4.app.JobIntentService
import android.util.Log
import com.abnormallydriven.paginglibrarytestdrive.teamlist.Team
import dagger.android.AndroidInjection
import javax.inject.Inject


class TeamSyncService : JobIntentService() {

    @Inject
    lateinit var footballApi : FootballApi

    @Inject
    lateinit var teamDao : TeamDao

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onHandleWork(intent: Intent) {
        Log.d("TeamSyncService", "Syncing data now")
        Log.d("TeamSyncService", "? " + (footballApi != null))
        Log.d("TeamSyncService", "Thread: " + Thread.currentThread().name)

        val competitionResponse = footballApi.getCompetitionList().execute()

        if(!competitionResponse.isSuccessful){
            val errorMessage = "Failed to get competition list. Code: ${competitionResponse.code()} , Error Body: ${competitionResponse.errorBody().toString()}"
            Log.d("TeamSyncService", errorMessage)
            return
        }

        val competitionList = competitionResponse.body() ?: return

        Log.d("TeamSyncService", "Competition List Size: ${competitionList?.size}")

        val completeTeamList: MutableList<Team> = mutableListOf()

        competitionList.forEach {
            if(it.id == null){
                return@forEach
            }

            val competitionId = it.id
            val teamListResponse = footballApi.getCompetitionTeamList(competitionId).execute()
            val teamListResponseBody = teamListResponse.body()

            if(!teamListResponse.isSuccessful || teamListResponseBody == null ||teamListResponseBody.teams == null){
                return@forEach
            }

            teamListResponseBody.teams.forEach {
                if(it?.crestUrl != null && it.name != null && it.id != null && it.shortName != null){
                    //convert to model and prepare to store in completeTeamList
                    completeTeamList.add(Team(competitionId, it.id, it.name, it.shortName, it.crestUrl))
                }
            }
        }

        completeTeamList.forEach(teamDao::insertTeam)

    }


    override fun onStopCurrentWork(): Boolean {
        return false
    }
}