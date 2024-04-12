package com.example.amphibians.ui

import androidx.compose.runtime.Composable
import com.example.amphibians.MyApplication
import com.example.amphibians.ui.screen.HomeScreen

private val myApplication: MyApplication = MyApplication()

@Composable
fun AmphibianApp() {
    HomeScreen(viewModel = myApplication.viewModel)
}