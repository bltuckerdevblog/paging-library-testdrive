package com.abnormallydriven.paginglibrarytestdrive.names

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface NamesActivitySubcomponent : AndroidInjector<NamesActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<NamesActivity>() {}
}