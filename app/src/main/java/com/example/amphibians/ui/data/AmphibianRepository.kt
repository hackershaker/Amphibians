package com.example.amphibians.ui.data

import com.example.amphibians.api.AmphibianPhotosApi
import retrofit2.http.GET

interface AmphibianPhotosRepository {
    suspend fun getPhotoList(): List<Amphibian>
}

class NetworkAmphibianPhotoRepository(private val retrofitService: AmphibianPhotosApi) :
    AmphibianPhotosRepository {

    @GET("amphibians?hl=ko/")
    override suspend fun getPhotoList(): List<Amphibian> {
        val list = retrofitService.getPhotosList()
        return list
    }
}