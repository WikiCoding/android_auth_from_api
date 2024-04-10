package com.wikicoding.loginexamplecompose.repositories

import com.wikicoding.loginexamplecompose.models.Token
import kotlinx.coroutines.flow.Flow

class AuthRepository(private val authDao: AuthDao) {
    suspend fun getToken(): Flow<Token> {
        return authDao.getToken()
    }

    suspend fun saveToken(token: Token) {
        return authDao.saveToken(token)
    }

    suspend fun deleteToken(token: Token) {
        return authDao.deleteToken(token)
    }
}