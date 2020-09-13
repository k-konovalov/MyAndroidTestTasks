package com.konovalovk.techno.guessit.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

class GameViewModel: ViewModel() {
    var guessInt = Random.nextInt(0, 9999)
    val tries = MutableLiveData(0)
    private val numberOfTries = AtomicInteger(0)
    val gameMsg = MutableLiveData("")

    fun checkAnswer(
        firstDigit: Int,
        secondDigit: Int,
        thirdDigit: Int,
        fourthDigit: Int
    ) {
        val userAnswer = "$firstDigit$secondDigit$thirdDigit$fourthDigit".toInt()
        var msg = "Answer is "

        msg += when {
            userAnswer > guessInt -> {
                tries.postValue(numberOfTries.incrementAndGet())
                "greater than stored value"}
            userAnswer < guessInt -> {
                tries.postValue(numberOfTries.incrementAndGet())
                "less than stored value"}
            else -> "you're right!"
        }

        gameMsg.postValue(msg)
    }
}