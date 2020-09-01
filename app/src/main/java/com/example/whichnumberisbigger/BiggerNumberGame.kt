package com.example.whichnumberisbigger

import kotlinx.android.synthetic.main.activity_main.*

class BiggerNumberGame(val lowerLimit: Int, val upperLimit: Int) {
    var leftNumber = 0
    var rightNumber = 0
    var score = 0

    init {
        randomNumberGenerator()
    }

    fun randomNumberGenerator() {
        leftNumber = (Math.random() * upperLimit + lowerLimit).toInt()
        rightNumber = (Math.random() * upperLimit + lowerLimit).toInt()
        while(leftNumber == rightNumber) {
            rightNumber = (Math.random() * upperLimit + lowerLimit).toInt()
        }
    }

    fun checkAnswer(answer : Int) : String {
        var result: String = ""
        var correctNumber = 0
        if(leftNumber > rightNumber) {
            correctNumber = leftNumber
        }
        else {
            correctNumber = rightNumber
        }
        if(answer == correctNumber) {
            score++
            randomNumberGenerator()
            result = "Correct! You're so smart!"
        }
        else {
            score--
            randomNumberGenerator()
            result = "Incorrect! Did you even pass kindergarten?"
        }
        return result
    }
}