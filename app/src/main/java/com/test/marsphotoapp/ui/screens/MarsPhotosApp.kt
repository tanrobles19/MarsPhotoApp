package com.test.marsphotoapp.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.test.marsphotoapp.R

@Composable
fun MarsPhotosApp() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text(text = stringResource(id = R.string.app_name))
            })
        }

    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            color = MaterialTheme.colorScheme.background
        ) {
            val marsViewModel : MarsViewModel = viewModel()
            val retryAction = marsViewModel::getMarsPhotos
//            HomeScreen(marsUIState = marsViewModel.      marsUIState)
            HomeScreenGrid(retryAction = retryAction, marsUIState = marsViewModel.marsUIState)
        }

    }

}