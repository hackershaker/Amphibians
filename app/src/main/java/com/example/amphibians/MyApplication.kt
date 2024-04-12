package com.example.amphibians

import android.app.Application
import com.example.amphibians.api.AmphibianPhotosApi
import com.example.amphibians.ui.data.NetworkAmphibianPhotoRepository
import com.example.amphibians.ui.screen.AmphibiansViewModel
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

class MyApplication : Application() {
    private val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"
    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
        .build()
    private val retrofitService = retrofit.create(AmphibianPhotosApi::class.java)
    private val repository = NetworkAmphibianPhotoRepository(retrofitService)
    val viewModel = AmphibiansViewModel(repository)
}