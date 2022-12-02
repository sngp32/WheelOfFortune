package com.example.wheeloffortune.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wheeloffortune.controller.GameController

@Composable
fun StartScreen(navController: NavController, gameController: GameController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color(0xff06aa61)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(90.dp))
        Text(
            text = "Welcome to the wheel of fortune!",
            fontSize = 38.sp,
            textAlign = TextAlign.Center,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Press 'Start' to start the game",
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
        )
        Button(
            onClick = {
                gameController.startGame()
                navController.navigate("game")
            },
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