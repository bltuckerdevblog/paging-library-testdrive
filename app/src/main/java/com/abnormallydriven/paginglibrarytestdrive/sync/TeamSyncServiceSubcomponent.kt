package com.abnormallydriven.paginglibrarytestdrive.sync

import android.app.Service
import dagger.Subcomponent
import dagger.android.AndroidInjector
import android.app.Activity



@Subcomponent
interface TeamSyncServiceSubcomponent : AndroidInjector<TeamSyncService> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TeamSyncService>() {}

}