package com.abnormallydriven.paginglibrarytestdrive.teamlist


import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap


@Module(subcomponents = arrayOf(TeamListSubcomponent::class))
abstract class TeamListInjectorModule{

    @Binds
    @IntoMap
    @ActivityKey(TeamListActivity::class)
    abstract fun bindInjectorFactory(builder : TeamListSubcomponent.Builder) : AndroidInjector.Factory<out Activity>

}



