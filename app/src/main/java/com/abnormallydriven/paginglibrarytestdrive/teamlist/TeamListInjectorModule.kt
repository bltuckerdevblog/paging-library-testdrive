package com.abnormallydriven.paginglibrarytestdrive.teamlist


import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector_Factory
import dagger.multibindings.IntoMap


@Module(subcomponents = arrayOf(TeamListSubComponent::class))
abstract class TeamListInjectorModule{

    @Binds
    @IntoMap
    @ActivityKey(TeamListActivity::class)
    abstract fun bindInjectorFactory(builder : TeamListSubComponent.Builder) : AndroidInjector.Factory<out Activity>

}



