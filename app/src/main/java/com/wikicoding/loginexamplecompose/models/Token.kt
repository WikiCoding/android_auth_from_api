package com.wikicoding.loginexamplecompose.models

import androidx.compose.runtime.Immutable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token_table")
@Immutable
data class Token(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var username: String = "",
    var token: String = ""
)
