package com.abnormallydriven.paginglibrarytestdrive.common

import com.abnormallydriven.paginglibrarytestdrive.PagingLibraryTestDriveApp
import com.abnormallydriven.paginglibrarytestdrive.names.NamesActivityInjectorModule
import com.abnormallydriven.paginglibrarytestdrive.products.ProductsActivityInjectorModule
import com.abnormallydriven.paginglibrarytestdrive.teamlist.sync.RoomModule
import com.abnormallydriven.paginglibrarytestdrive.teamlist.sync.TeamSyncServiceInjectorModule
import com.abnormallydriven.paginglibrarytestdrive.teamlist.TeamListInjectorModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [(HttpModule::class),
    (AndroidInjectionModule::class),
    (ApplicationModule::class),
    (TeamSyncServiceInjectorModule::class),
    (TeamListInjectorModule::class),
    (ViewModelsModule::class),
    (RoomModule::class),
    (NamesActivityInjectorModule::class),
    (ProductsActivityInjectorModule::class)])
interface ApplicationComponent {

    fun inject(pagingLibraryTestDriveApp: PagingLibraryTestDriveApp)
}