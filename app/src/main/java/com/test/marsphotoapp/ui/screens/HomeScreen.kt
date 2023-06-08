package com.test.marsphotoapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.test.marsphotoapp.R
import com.test.marsphotoapp.model.MarsPhoto

@Composable
fun HomeScreen(marsUIState: MarsUIState, modifier : Modifier = Modifier) {
    
    when(marsUIState) {
        is MarsUIState.Loading -> LoadingScreen(modifier)
        is MarsUIState.Success -> MarsPhotoCard(photo = marsUIState.photo, modifier = modifier)
        is MarsUIState.Error -> ErrorScreen("")
    }
    
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
//        Text(text = photos)
    }
}
@Composable
fun ResultScreen(photos: String, modifier: Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
//        Text(text = photos)

        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(photos + "12")
                .crossfade(true)
                .build(),
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.mars_photo),
            contentScale = ContentScale.FillBounds,
            onError = { println(it.result.throwable) }

        )

//        AsyncImage(
//            model = "https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg",
//            contentDescription = null
//        )

//        AsyncImage(
//            model = ImageRequest.Builder(LocalContext.current)
//                .data(photos)
//                .crossfade(true)
//                .build(),
//            placeholder = painterResource(R.drawable.loading_img),
//            contentDescription = stringResource(R.string.loading),
//            contentScale = ContentScale.Crop,
//            modifier = Modifier.clip(CircleShape)
//        )
    }
}

@Composable
fun MarsPhotoCard(photo: MarsPhoto, modifier: Modifier = Modifier) {
    AsyncImage(
        model = ImageRequest.Builder(context = LocalContext.current)
            .data(photo.imgSrc)
            .crossfade(true)
            .build(),
        contentDescription = stringResource(R.string.mars_photo),
        contentScale = ContentScale.FillBounds
    )
}

@Composable
fun ErrorScreen(photos: String) {
    Box(
    ) {
        Text(text = photos)
    }
}