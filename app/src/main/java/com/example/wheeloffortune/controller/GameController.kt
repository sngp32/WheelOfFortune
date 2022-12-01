package com.example.wheeloffortune.controller

import java.util.*
import kotlin.random.Random.Default.nextInt

object GameController {
    private val wheelValues = listOf("100","200","500","1000","bankrupt")
    private val words = listOf("Hej", "Med", "Dig")
    private var randomWord: MutableMap<Char, Char>? = null
    private var currentWheelValue = "100"
    private var lives = 5

    fun generateRandomWord(): MutableMap<Char, Char>? {
        val map = mutableMapOf<Char,Char>()
        for (element in words.random()) {
            map[element] = '*'
        }
        randomWord = map
        return randomWord
    }

    fun getDisplayedWord(): String {
        var displayedWord = ""
        for((key, value) in randomWord.orEmpty()){
            displayedWord+=value
        }
        return displayedWord
    }

    fun spinWheel(): String {
        currentWheelValue = wheelValues.random()
        return currentWheelValue
    }

    fun getCurrentWheelValue(): String {
        return currentWheelValue
    }
}