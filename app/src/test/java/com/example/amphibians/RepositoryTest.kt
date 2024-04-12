package com.example.amphibians

import com.example.amphibians.fake.FakeDataSource
import com.example.amphibians.fake.FakeNetworkAmphibianPhotosApi
import com.example.amphibians.ui.data.NetworkAmphibianPhotoRepository
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test


class RepositoryTest {

    @Test
    fun repository_mockAPI_test() = runTest {
        val repository = NetworkAmphibianPhotoRepository(FakeNetworkAmphibianPhotosApi())
        Assert.assertEquals(repository.getPhotoList(), FakeDataSource().PhotoList)
    }

}
