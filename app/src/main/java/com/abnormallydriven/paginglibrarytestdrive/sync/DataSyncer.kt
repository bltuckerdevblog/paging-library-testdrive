package com.abnormallydriven.paginglibrarytestdrive.sync

import android.arch.lifecycle.DefaultLifecycleObserver
import android.arch.lifecycle.LifecycleOwner
import android.content.Context
import android.content.Intent
import android.support.v4.app.JobIntentService
import com.abnormallydriven.paginglibrarytestdrive.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class DataSyncer @Inject constructor( @ApplicationContext private val appContext : Context) : DefaultLifecycleObserver {

    override fun onCreate(owner: LifecycleOwner?) {
        val workIntent = Intent(appContext, TeamSyncService::class.java)
        JobIntentService.enqueueWork(appContext, TeamSyncService::class.java, 1, workIntent)
    }
}