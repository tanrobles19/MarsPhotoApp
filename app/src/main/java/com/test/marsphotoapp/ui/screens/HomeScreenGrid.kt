package com.test.marsphotoapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.marsphotoapp.R
import com.test.marsphotoapp.model.MarsPhoto
import com.test.marsphotoapp.ui.theme.MarsPhotosTheme

@Composable
fun HomeScreenGrid(marsUIState: MarsUIState, retryAction: () -> Unit, modifier: Modifier = Modifier){
//    MarsPhotoCard(photo = marsUIState.)

    when(marsUIState) {
        is MarsUIState.Loading -> {}
        is MarsUIState.Success -> MarsPhotoGrid(photoList = marsUIState.photoList)
        is MarsUIState.Error -> ErrorScreen({ }, modifier.fillMaxSize())


        cuando se pone Offline se desmadra...

    }

}

@Composable
fun MarsPhotoGrid(photoList: List<MarsPhoto>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 150.dp),
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(photoList) {photo ->
//            Text(text = photo.id)
            MarsPhotoCard(
                photo = photo,
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
                    .aspectRatio(1.5f)
            )

        }
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        Image(painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = "")
        Text(text = stringResource(id = R.string.loading_failed), modifier = Modifier.padding(16.dp))
        Button(onClick = {  }) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhotosGridScreenPreview() {
    MarsPhotosTheme {
        val mockData = List(10){ MarsPhoto("$it", "https://mars.nasa.gov/msl-raw-images/msss/01000/mcam/1000MR0044631300503690E01_DXXX.jpg")}
//        MarsPhotoGrid(photoList = mockData)
        ErrorScreen({})
    }
}