package com.wikicoding.loginexamplecompose.uiscreens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.wikicoding.loginexamplecompose.models.User
import com.wikicoding.loginexamplecompose.viewmodel.MainViewModel

@Composable
fun LoginScreen(navHostController: NavHostController, mainViewModel: MainViewModel) {
    var nameState by remember { mutableStateOf("") }
    var passState by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = nameState,
                onValueChange = { nameState = it }, placeholder = {
                Text(
                    text = "Username"
                )
            })
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            OutlinedTextField(modifier = Modifier.fillMaxWidth(), value = passState,
                onValueChange = { passState = it }, placeholder = {
                Text(
                    text = "Password"
                )
            })
        }

        Row {
            Button(
                onClick = {
                    mainViewModel.login(User(nameState, passState)) { success ->
                        if (success) {
                            navHostController.navigate(Screen.DashboardScreen.route)
                        } else {
                            Toast.makeText(context, "Error in login", Toast.LENGTH_SHORT).show()
                        }
                    }
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(text = "Login")
            }
        }
    }
}