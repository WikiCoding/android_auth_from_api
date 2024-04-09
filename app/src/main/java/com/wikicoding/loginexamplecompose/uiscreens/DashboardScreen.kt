package com.wikicoding.loginexamplecompose.uiscreens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wikicoding.loginexamplecompose.viewmodel.MainViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DashBoardScreenView(
    navHostController: NavHostController,
    mainViewModel: MainViewModel
) {
    mainViewModel.getPlaces()
    val places = mainViewModel.placesState
//    Log.e("places", places.value.toString())

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Row {
            Text(text = "Welcome to the dashboard!")
        }

        Button(modifier = Modifier.fillMaxWidth(), onClick = {
            mainViewModel.tokenState = ""
            navHostController.navigateUp()
        }) {
            Text(text = "Logout")
        }

        Box(modifier = Modifier.weight(0.8f)) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(items = places.value, key = { item -> item._id }) { place ->
                    LazyColumnElement(place = place)
                }
            }
        }
    }
}