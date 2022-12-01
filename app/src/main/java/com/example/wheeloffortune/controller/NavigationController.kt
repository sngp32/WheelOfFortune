package com.example.wheeloffortune.controller

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.wheeloffortune.view.GameScreen
import com.example.wheeloffortune.view.StartScreen


@Composable
    fun Navigation() {
        val navController = rememberNavController()
        val gameController = GameController()
        NavHost(navController = navController, startDestination = "start") {
            composable("start") { StartScreen(navController = navController, gameController) }
            composable("game") { GameScreen(navController = navController, gameController) }
        }
    }
