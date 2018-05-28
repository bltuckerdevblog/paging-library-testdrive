package com.abnormallydriven.paginglibrarytestdrive.teamlist.sync


import android.arch.persistence.room.Room
import android.content.Context
import com.abnormallydriven.paginglibrarytestdrive.common.ApplicationContext

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
