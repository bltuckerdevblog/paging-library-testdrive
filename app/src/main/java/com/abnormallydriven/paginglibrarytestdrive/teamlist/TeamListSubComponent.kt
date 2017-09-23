package com.abnormallydriven.paginglibrarytestdrive.teamlist

import com.abnormallydriven.paginglibrarytestdrive.ActivityScope
import dagger.Subcomponent
import dagger.android.AndroidInjector


@Subcomponent
interface TeamListSubComponent : AndroidInjector<TeamListActivity> {


    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<TeamListActivity>() {}

}