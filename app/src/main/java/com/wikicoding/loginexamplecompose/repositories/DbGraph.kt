package com.wikicoding.loginexamplecompose.repositories

import android.content.Context
import androidx.room.Room

object DbGraph {
    private lateinit var authDatabase: AuthDatabase

    val authRepository by lazy {
        AuthRepository(authDatabase.authDao())
    }

    fun provide(context: Context) {
        authDatabase = Room.databaseBuilder(
            context,
            AuthDatabase::class.java,
            "compose_auth_database.db"
        )
//            .fallbackToDestructiveMigration()
            .build()
    }
}