package com.abnormallydriven.paginglibrarytestdrive

import com.abnormallydriven.paginglibrarytestdrive.teamlist.TeamListInjectorModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(HttpModule::class,
        AndroidInjectionModule::class,
        ApplicationModule::class,
        TeamListInjectorModule::class))
interface ApplicationComponent {

    fun inject(pagingLibraryTestDriveApp: PagingLibraryTestDriveApp)
}