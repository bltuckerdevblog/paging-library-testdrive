package com.abnormallydriven.paginglibrarytestdrive.sync


import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.abnormallydriven.paginglibrarytestdrive.ApplicationContext
import com.abnormallydriven.paginglibrarytestdrive.teamlist.Team

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(@ApplicationContext context: Context) : TeamDatabase{
        return Room.databaseBuilder(context, TeamDatabase::class.java, "teamdatabase").build()
    }

    @Provides
    @Singleton
    fun provideTeamDao(teamDb: TeamDatabase) : TeamDao{
        return teamDb.teamDao()
    }
}
