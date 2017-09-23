package com.abnormallydriven.paginglibrarytestdrive.sync

import android.content.Intent
import android.support.v4.app.JobIntentService
import android.util.Log


class TeamSyncService : JobIntentService() {


    override fun onHandleWork(intent: Intent) {
        Log.d("TeamSyncService", "Syncing data now")
    }
}