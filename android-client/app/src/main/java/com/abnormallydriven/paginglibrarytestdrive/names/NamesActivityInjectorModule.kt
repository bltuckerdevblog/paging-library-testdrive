package com.abnormallydriven.paginglibrarytestdrive.names

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(subcomponents = [(NamesActivitySubcomponent::class)])
abstract class NamesActivityInjectorModule {

    @Binds
    @IntoMap
    @ActivityKey(NamesActivity::class)
    abstract fun bindInjectorFactory(builder: NamesActivitySubcomponent.Builder) : AndroidInjector.Factory<out Activity>

}