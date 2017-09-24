package com.abnormallydriven.paginglibrarytestdrive.sync

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.abnormallydriven.paginglibrarytestdrive.teamlist.Team

@Database(entities = arrayOf(Team::class), version = 1)
abstract class TeamDatabase : RoomDatabase() {
    abstract fun teamDao() : TeamDao
}