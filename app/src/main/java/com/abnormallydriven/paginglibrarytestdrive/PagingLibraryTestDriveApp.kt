package com.abnormallydriven.paginglibrarytestdrive

import android.app.Activity
import android.app.Application
import android.app.Service
import com.abnormallydriven.paginglibrarytestdrive.common.ApplicationComponent
import com.abnormallydriven.paginglibrarytestdrive.common.ApplicationModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.HasServiceInjector
import javax.inject.Inject

//person name search

class PagingLibraryTestDriveApp: Application(), HasActivityInjector, HasServiceInjector {

    companion object {
        lateinit var applicationComponent : ApplicationComponent
    }

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    @Inject
    lateinit var dispatchingServiceInjector : DispatchingAndroidInjector<Service>

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector
    }

    override fun serviceInjector(): AndroidInjector<Service> {
        return dispatchingServiceInjector
    }

}