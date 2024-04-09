package com.wikicoding.loginexamplecompose.dtos

data class UserResponse(
    var _id: String = "",
    var name: String = "",
    var password: String = "",
    var token: String = "",
    var __v: Int = 0
)
