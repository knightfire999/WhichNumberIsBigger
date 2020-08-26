package com.example.whichnumberisbigger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var score = 0
    private var leftValue = 0
    private var rightValue = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game()
    }

    private fun game() {
        leftValue = (Math.random() * 100 + 1).toInt()
        rightValue = (Math.random() * 100 + 1).toInt()
        while (leftValue == rightValue) {
            rightValue = (Math.random() * 100 + 1).toInt()
        }
        button_main_left.setText(leftValue.toString())
        button_main_right.setText(rightValue.toString())
        textView_main_score.text = score.toString()
    }

    fun onLeftClick(view: View) {
        button_main_left.setText(leftValue.toString())
        if (leftValue > rightValue) {
            score++
            Toast.makeText(this, "Correct! You're so smart!", Toast.LENGTH_SHORT).show()
            game()
        }
        else {
            score--
            Toast.makeText(this, "Incorrect! Did you even pass kindergarten?", Toast.LENGTH_SHORT).show()
            game()
        }
    }

    fun onRightClick(view: View) {
        if (rightValue > leftValue) {
            score++
            Toast.makeText(this, "Correct! You're so smart!", Toast.LENGTH_SHORT).show()
            game()
        }
        else {
            score--
            Toast.makeText(this, "Incorrect! Did you even pass kindergarten?", Toast.LENGTH_SHORT).show()
            game()
        }
    }
}