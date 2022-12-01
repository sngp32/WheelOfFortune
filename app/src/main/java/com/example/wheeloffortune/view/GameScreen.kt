package com.example.wheeloffortune.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wheeloffortune.controller.GameController

@Composable
fun GameScreen(navController: NavController) {
    Column() {
        Text(text = "The word is")
        GameController.generateRandomWord()
        Text(text = GameController.getDisplayedWord())
        Text(text = "Spin the wheel!")
        var wheelValue by remember { mutableStateOf("")}
        Button(
            onClick = { wheelValue = GameController.spinWheel() },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(
                    0xFF454545
                )
            ),
            modifier = Modifier.width(300.dp)
        ) {
            Text(text = "Spin", color = Color.White)
        }

        if (wheelValue.length>0) {
            Text(text = "The wheel landed on "+wheelValue)
        }
    }
}
