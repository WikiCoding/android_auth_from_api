package com.wikicoding.loginexamplecompose.repositories

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.wikicoding.loginexamplecompose.models.Token
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AuthDao {
    @Query("SELECT * FROM `token_table` LIMIT 1")
    abstract fun getToken(): Flow<Token>
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun saveToken(token: Token)

    @Transaction
    @Delete
    abstract suspend fun deleteToken(token: Token)

}