package com.wikicoding.loginexamplecompose

import android.app.Application
import com.wikicoding.loginexamplecompose.repositories.DbGraph

class DbApp: Application() {
    override fun onCreate() {
        super.onCreate()
        DbGraph.provide(this)
    }
}