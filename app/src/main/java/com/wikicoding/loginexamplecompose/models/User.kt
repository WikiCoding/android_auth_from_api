package com.wikicoding.loginexamplecompose.models

import java.io.Serializable

data class User(
    var name: String,
    var password: String,
): Serializable
