package com.abnormallydriven.paginglibrarytestdrive.teamlist

import android.arch.lifecycle.ViewModel
import com.abnormallydriven.paginglibrarytestdrive.sync.TeamDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TeamsViewModel @Inject
constructor(private val teamDao: TeamDao) : ViewModel(){


}
