package com.example.wheeloffortune.view

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun StartScreen(navController: NavController) {
    Column() {
        Text(text = "Hello!")
    }
}