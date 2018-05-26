package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface TeamSyncServiceSubcomponent : AndroidInjector<TeamSyncService> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TeamSyncService>() {}

}