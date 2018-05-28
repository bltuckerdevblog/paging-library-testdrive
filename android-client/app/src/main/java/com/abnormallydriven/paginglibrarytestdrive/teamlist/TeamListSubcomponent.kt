package com.abnormallydriven.paginglibrarytestdrive.teamlist

import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface TeamListSubcomponent : AndroidInjector<TeamListActivity> {


    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TeamListActivity>() {}

}