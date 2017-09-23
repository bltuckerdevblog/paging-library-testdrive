package com.abnormallydriven.paginglibrarytestdrive.sync

import android.content.Intent
import android.support.v4.app.JobIntentService
import android.util.Log
import dagger.android.AndroidInjection
import javax.inject.Inject


class TeamSyncService : JobIntentService() {

    @Inject
    lateinit var footballApi : FootballApi

    override fun onCreate() {
        AndroidInjection.inject(this)
        super.onCreate()
    }

    override fun onHandleWork(intent: Intent) {
        Log.d("TeamSyncService", "Syncing data now")
        Log.d("TeamSyncService", "? " + (footballApi != null))



    }
}