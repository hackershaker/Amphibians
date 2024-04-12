package com.example.amphibians.fake

import com.example.amphibians.api.AmphibianPhotosApi

interface FakeAmphibianPhotosApi : AmphibianPhotosApi {
    override suspend fun getPhotosList() = FakeDataSource().PhotoList
}

class FakeNetworkAmphibianPhotosApi : FakeAmphibianPhotosApi {
}