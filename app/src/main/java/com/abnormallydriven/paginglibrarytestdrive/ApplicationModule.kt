package com.abnormallydriven.paginglibrarytestdrive

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import java.io.File
import javax.inject.Singleton


@Module
class ApplicationModule(private val applicationContent: PagingLibraryTestDriveApp) {


    @Provides
    @Singleton
    @ApplicationContext
    fun provideAppContext() : Context{
        return applicationContent
    }

    @Provides
    @Singleton
    fun provideCacheDirectory(): File {
        return applicationContent.cacheDir
    }

    @Provides
    @Singleton
    fun provideSharedPreferences() : SharedPreferences{
        return PreferenceManager.getDefaultSharedPreferences(applicationContent)
    }

}