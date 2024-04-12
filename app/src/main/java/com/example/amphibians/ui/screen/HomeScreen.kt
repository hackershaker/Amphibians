package com.example.amphibians.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibians.R
import com.example.amphibians.ui.data.Amphibian
import com.example.compose.AmphibiansTheme

@Composable
fun HomeScreen(viewModel: AmphibiansViewModel) {
    val uiState = viewModel.uiState.collectAsState()

    when (uiState.value) {
        is ResponseState.isLoading -> LoadingScreen()
        is ResponseState.isError -> ErrorScreen((uiState.value as ResponseState.isError).error)
        is ResponseState.isSuccess -> SuccessScreen((uiState.value as ResponseState.isSuccess).photoList)
    }
}

@Composable
fun LoadingScreen() {
    Text(text = "Loading..")
}

@Composable
fun ErrorScreen(error: Exception) {
    Text(text = error.toString())
}

@Composable
fun SuccessScreen(photoList: List<Amphibian>) {
    PhotoList(photoList)
}

@Composable
fun PhotoList(photoList: List<Amphibian>) {
    LazyColumn(userScrollEnabled = true) {
        items(photoList) {
            PhotoCard(amphibian = it)
        }
    }
}

@Composable
fun PhotoCard(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(4.dp))
    ) {

        Column(modifier = Modifier.padding(12.dp)) {
            Text(text = amphibian.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = amphibian.type, style = MaterialTheme.typography.bodyMedium)
            AsyncImage(
                model = amphibian.imgSrc,
                contentDescription = "amphibian image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1.2f),
                error = painterResource(id = R.drawable.image_load_failed),
                placeholder = painterResource(id = R.drawable.pending)
            )
            Text(text = amphibian.description, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotoCardPreview() {
    AmphibiansTheme {
        val testAmphibian = Amphibian(
            name = "Frog",
            type = "frog",
            description = "Cute frog.",
            imgSrc = "https://cdn.mos.cms.futurecdn.net/39CUYMP8vJqHAYGVzUghBX-970-80.jpg"
        )
        PhotoCard(amphibian = testAmphibian)
    }
}