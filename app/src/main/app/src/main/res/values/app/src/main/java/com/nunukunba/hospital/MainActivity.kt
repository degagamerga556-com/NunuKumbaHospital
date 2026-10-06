package com.nunukunba.hospital

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HospitalApp()
                }
            }
        }
    }
}

@Composable
fun HospitalApp() {

    var loggedIn by remember { mutableStateOf(false) }

    if (loggedIn) {
        DashboardScreen()
    } else {
        LoginScreen(
            onLogin = {
                loggedIn = true
            }
        )
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Nunu Kumba Hospital",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Hospital Management System"
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = onLogin,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("LOGIN")
        }
    }
}

@Composable
fun DashboardScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Hospital Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Nunu Kumba Hospital"
        )

        Spacer(modifier = Modifier.height(30.dp))

        DashboardButton("Patient Registration")
        DashboardButton("OPD / Clinical")
        DashboardButton("Laboratory")
        DashboardButton("Pharmacy")
        DashboardButton("Blood Bank")
        DashboardButton("Insurance")
        DashboardButton("HMIS Reports")
    }
}

@Composable
fun DashboardButton(title: String) {

    Button(
        onClick = {
            // Module will be connected later
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    ) {
        Text(title)
    }
}
