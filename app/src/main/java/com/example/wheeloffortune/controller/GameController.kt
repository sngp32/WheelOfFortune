package com.example.wheeloffortune.controller

class GameController {
    private val wheelValues: List<String> =
        listOf("100", "200", "300", "400", "500", "600", "1000", "bankrupt")

    // TODO - import words from list...
    private val words = listOf<String>(
        "explode",
        "seize",
        "plan",
        "speed",
        "extract",
        "tremble",
        "illustrate",
        "examine",
        "shiver",
        "be",
        "bound",
        "purchase",
        "pour",
        "afford",
        "scan",
        "aim",
        "disagree",
        "vote",
        "execute",
        "go",
        "exclude",
        "forget",
        "hear",
        "refer",
        "quote",
        "contract",
        "sort",
        "burn",
        "update"
    )
    private var randomWord: String = ""
    private var displayedWord: String = ""
    private var currentWheelValue = "100"
    private var lives = 5
    private var points = 0
    private var missingChars = 0

    /**
     * Resets variables when game starts/restarts
     */
    fun startGame() {
        lives = 5
        points = 0
        displayedWord = ""
        generateRandomWord()
    }

    /**
     * Finds a random word from the word list, and make a corresponding "hidden" word consisting
     * of '*' which is shown to the user
     */
    fun generateRandomWord(): String {
        val map = mutableMapOf<Char, Char>()
        missingChars = 0

        val word = words.shuffled()[0]
        for (element in word) {
            displayedWord += '*'
            missingChars++
        }
        randomWord = word
        return randomWord
    }

    /**
     * Returns the word to be displayed for the user
     */
    fun getDisplayedWord(): String {
        return displayedWord
    }

    fun spinWheel(): String {
        currentWheelValue = wheelValues.shuffled()[0]
        if (currentWheelValue == "bankrupt") {
            points = 0
        }
        return currentWheelValue
    }

    fun getCurrentWheelValue(): String {
        return currentWheelValue
    }

    fun getPoints(): Int {
        return points
    }

    /**
     * Checks whether the user guessed right or wrong, and then adds the right amount of points
     * to the user.
     */
    fun checkChar(char: Char): Int {
        var multiplier: Int = 0
        var charArray = displayedWord.toCharArray()
        for (index in 0..randomWord.length - 1) {
            if (randomWord[index] == char) {
                charArray[index] = char
                displayedWord = String(charArray)
                multiplier++
                missingChars--
            }
        }
        if (multiplier > 0) {
            points += currentWheelValue.toInt() * multiplier
        } else {
            lives--
        }
        return multiplier
    }

    fun getLives(): Int {
        return lives
    }

    fun getMissingChars(): Int {
        return missingChars
    }

    fun getRandomWord(): String {
        return randomWord
    }
}