package com.example.whichnumberisbigger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var game = BiggerNumberGame(0, 100)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        game.randomNumberGenerator()
        update()
    }

    fun update() {
        button_main_left.text = game.leftNumber.toString()
        button_main_right.text = game.rightNumber.toString()
        textView_main_score.text = game.score.toString()
    }

    fun onLeftClick(view: View) {
        textView_main_score.text = game.score.toString()
        Toast.makeText(this, game.checkAnswer(button_main_left.text.toString().toInt()), Toast.LENGTH_SHORT).show()
        update()
    }

    fun onRightClick(view: View) {
        Toast.makeText(this, game.checkAnswer(button_main_right.text.toString().toInt()), Toast.LENGTH_SHORT).show()
        textView_main_score.text = game.score.toString()
        update()
    }
}