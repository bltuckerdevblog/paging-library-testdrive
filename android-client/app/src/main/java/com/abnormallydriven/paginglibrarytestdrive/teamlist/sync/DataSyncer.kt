package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v4.app.JobIntentService
import com.abnormallydriven.paginglibrarytestdrive.common.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataSyncer @Inject constructor(@ApplicationContext private val appContext : Context,
                                     private val sharedPreferences: SharedPreferences) : DefaultLifecycleObserver {

    companion object {
        val SYNC_PERIOD = 1000 * 60 * 60
    }


    override fun onCreate(owner: LifecycleOwner) {
        val lastSyncTime = sharedPreferences.getLong("lastSyncTime", 0)
        val currentTime = System.currentTimeMillis()

        if(currentTime - lastSyncTime < SYNC_PERIOD){
            return
        }

        sharedPreferences.edit().putLong("lastSyncTime", currentTime).apply()
        val workIntent = Intent(appContext, TeamSyncService::class.java)
        JobIntentService.enqueueWork(appContext, TeamSyncService::class.java, 1, workIntent)
    }
}