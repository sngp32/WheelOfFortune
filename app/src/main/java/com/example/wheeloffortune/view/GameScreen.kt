package com.example.wheeloffortune.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.wheeloffortune.controller.GameController

@Composable
fun GameScreen(navController: NavController, gameController: GameController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(Color(0xff06aa61)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        var lives by remember { mutableStateOf(gameController.getLives()) }
        Text(text = "Your lives: " + lives)
        var points by remember { mutableStateOf(gameController.getPoints()) }
        Text(text = "Your points: " + points)
        Text(
            text = "The word is", fontSize = 38.sp,
            color = Color.White
        )
        var randomWord by remember { mutableStateOf(gameController.getDisplayedWord()) }
        Text(text = randomWord, fontSize = 38.sp)

        Spacer(modifier = Modifier.height(40.dp))
        if (gameController.getMissingChars() != 0 && gameController.getLives() != 0) {
            var spinText by remember { mutableStateOf("Spin the wheel!") }
            Text(text = spinText)
            Spacer(modifier = Modifier.height(20.dp))
            var wheelValue by remember { mutableStateOf("") }
            var spinEnabled by remember { mutableStateOf(true) }
            Button(
                onClick = {
                    wheelValue = gameController.spinWheel()
                    points = gameController.getPoints()
                    spinEnabled = wheelValue == "bankrupt"
                },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(
                        0xFF454545
                    )
                ),
                modifier = Modifier.width(300.dp).height(50.dp),
                enabled = spinEnabled
            ) {
                Text(text = "Spin", color = Color.White)
            }

            if (wheelValue.length > 0) {
                Text(text = "The wheel landed on " + wheelValue)
                if (wheelValue == "bankrupt") {
                    Text(text = "and you lost all your points :( ")
                } else {
                    var character: MutableState<String> = remember { mutableStateOf("") }

                    OutlinedTextField(
                        value = character.value,
                        onValueChange = { input -> character.value = input },
                        label = { Text(text = "Select character") },
                        modifier = Modifier.width(300.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White
                        )
                    )
                    if (character.value.length == 1) {
                        Button(
                            onClick = {
                                if (gameController.checkChar(character.value[0]) == 0) {
                                    wheelValue = ""
                                    spinText = "You guessed wrong and lost a life.. Spin again!"
                                    spinEnabled = true
                                } else {
                                    spinText = "Spin the wheel!"
                                }
                                points = gameController.getPoints()
                                lives = gameController.getLives()
                                randomWord = gameController.getDisplayedWord()
                            },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(
                                    0xFF454545
                                )
                            ),
                            modifier = Modifier.width(300.dp).height(50.dp)
                        ) {
                            Text(text = "Check character", color = Color.White)
                        }
                    }
                }
            }

        }
        if (gameController.getLives() < 1 || gameController.getMissingChars() == 0) {
            randomWord = gameController.getRandomWord()
            Column {
                Text(text = "Game Over")
                Text(text = "Points: " + points)
                Button(
                    onClick = {
                        gameController.startGame()
                        lives = gameController.getLives()
                        points = gameController.getPoints()
                        randomWord = gameController.getDisplayedWord()
                        navController.navigate("start")
                    },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color(
                            0xFF454545
                        )
                    ),
                    modifier = Modifier.width(300.dp).height(60.dp)
                ) {
                    Text(text = "Close game", color = Color.White)
                }
            }
        }
    }
}