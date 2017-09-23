package com.abnormallydriven.paginglibrarytestdrive.sync

import android.app.Service
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.ServiceKey
import dagger.multibindings.IntoMap

@Module(subcomponents = arrayOf(TeamSyncServiceSubcomponent::class))
abstract class TeamSyncServiceInjectorModule {

    @Binds
    @IntoMap
    @ServiceKey(TeamSyncService::class)
    abstract fun bindInjectorFactory(builder: TeamSyncServiceSubcomponent.Builder) : AndroidInjector.Factory<out Service>

}