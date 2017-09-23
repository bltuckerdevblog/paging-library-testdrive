package com.abnormallydriven.paginglibrarytestdrive

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


class PagingLibraryTestDriveApp: Application(), HasActivityInjector {

    companion object {
        lateinit var applicationComponent : ApplicationComponent
    }

    @Inject
    lateinit var dispatchingAndroidInjector : DispatchingAndroidInjector<Activity>


    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

        applicationComponent.inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingAndroidInjector
    }

}