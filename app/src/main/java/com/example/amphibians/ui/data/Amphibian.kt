package com.example.amphibians.ui.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Amphibian(
    val description: String,
    @SerialName("img_src") val imgSrc: String,
    val name: String,
    val type: String
) {

}