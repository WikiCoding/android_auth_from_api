package com.wikicoding.loginexamplecompose.sharedPrefs

import android.content.Context
import androidx.core.content.edit

class TokenManager(context: Context) {
    private val sharedPrefs = context.getSharedPreferences("loginPrefs", Context.MODE_PRIVATE)

    fun saveString(key: String, value: String) {
        sharedPrefs.edit {
            putString(key, value)
            apply()
        }
    }

    fun getStringToken(key: String, defaultValue: String = ""): String {
        return sharedPrefs.getString(key, defaultValue) ?: defaultValue
    }

    fun getStringUsername(key: String, defaultValue: String = ""): String {
        return sharedPrefs.getString(key, defaultValue) ?: defaultValue
    }

    fun deleteString(usernameKey: String, key: String) {
        sharedPrefs.edit {
            remove(usernameKey)
            remove(key)
            apply()
        }
    }
}