package com.example.amphibians.fake

import com.example.amphibians.ui.data.Amphibian

class FakeDataSource() {
    val PhotoList = List(10) { Amphibian("", "", "", "") }
}