package com.wikicoding.loginexamplecompose.repositories

import androidx.room.Database
import androidx.room.RoomDatabase
import com.wikicoding.loginexamplecompose.models.Token

@Database(entities = [Token::class], version = 1, exportSchema = false)
abstract class AuthDatabase: RoomDatabase() {
    abstract fun authDao(): AuthDao
}