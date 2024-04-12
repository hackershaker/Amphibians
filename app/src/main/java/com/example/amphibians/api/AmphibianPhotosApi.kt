package com.example.amphibians.api

import com.example.amphibians.ui.data.Amphibian
import retrofit2.http.GET

interface AmphibianPhotosApi {
    @GET("amphibians?hl=ko")
    suspend fun getPhotosList(): List<Amphibian>
}