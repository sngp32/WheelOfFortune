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
import com.example.wheeloffortune.controller.GameController

@Composable
fun StartScreen(navController: NavController, gameController: GameController) {
    Column() {
        Text(text = "Welcome to the wheel of fortune!")
        Text(text = "Press 'Start' to start the game")
        Button(
            onClick = { gameController.startGame()
                        navController.navigate("game")},
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