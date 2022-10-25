package com.tahaaltuntas.nasapp.data.model

import com.google.gson.annotations.SerializedName

data class NasaModel (
    val photos: List<Photo>
)

data class Photo (
    val id: Long,
    val sol: Long,
    val camera: Camera,
    @SerializedName("img_src")
    val imgSrc: String,
    @SerializedName("earth_date")
    val earthDate: String,
    val rover: Rover
)

data class Camera (
    val id: Long,
    val name: String,
    @SerializedName("rover_id")
    val roverID: Long,
    @SerializedName("full_name")
    val fullName: String
)

data class Rover (
    val id: Long,
    val name: String,
    @SerializedName("landing_date")
    val landingDate: String,
    @SerializedName("launch_date")
    val launchDate: String,
    val status: String
)