package com.wikicoding.loginexamplecompose.models

import java.io.Serializable

data class Place(
    var _id: String = "",
    var placeName: String = "",
    var placeAddress: String = "",
    var placeDescription: String = "",
    var placeLatitude: Double = 0.0,
    var placeLongitude: Double = 0.0,
    var placeImageUrl: String = "",
    var owner: String = "",
    var __v : Int = 0
): Serializable
