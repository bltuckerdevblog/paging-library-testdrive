package com.abnormallydriven.paginglibrarytestdrive

import com.abnormallydriven.paginglibrarytestdrive.sync.RoomModule
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamSyncServiceInjectorModule
import com.abnormallydriven.paginglibrarytestdrive.teamlist.TeamListInjectorModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(HttpModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        TeamSyncServiceInjectorModule::class,
        TeamListInjectorModule::class,
        RoomModule::class))
interface ApplicationComponent {

    fun inject(pagingLibraryTestDriveApp: PagingLibraryTestDriveApp)
}