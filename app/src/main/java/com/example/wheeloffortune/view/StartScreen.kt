package com.example.wheeloffortune.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController) {
    Column() {
        Text(text = "Welcome to the wheel of fortune!")
        Text(text = "Press 'Start' to start the game")
        Button(
            onClick = { navController.navigate("game") },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    0xFF454545
                )
            ),
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Start", color = Color.White)
        }
    }
}