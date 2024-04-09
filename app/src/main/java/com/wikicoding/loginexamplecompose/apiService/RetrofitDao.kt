package com.wikicoding.loginexamplecompose.apiService

import com.wikicoding.loginexamplecompose.models.Place
import com.wikicoding.loginexamplecompose.dtos.ResponseMessage
import com.wikicoding.loginexamplecompose.models.User
import com.wikicoding.loginexamplecompose.dtos.UserResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface RetrofitDao {
    @POST("/login")
    suspend fun login(@Body user: User): UserResponse

    @Headers("Content-Type: application/json")
    @POST("/logout")
    suspend fun logout(): ResponseMessage

    @Headers("Content-Type: application/json")
    @GET("/place")
    suspend fun getPlaces(): List<Place>
}