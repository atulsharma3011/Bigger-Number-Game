package com.example.biggernumber

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        assignNumbersToButtons()
        button1.setOnClickListener {
            checkAnswer(true)
            assignNumbersToButtons()
        }

        button2.setOnClickListener {
            checkAnswer(false)
            assignNumbersToButtons()
        }
    }

    private fun assignNumbersToButtons() {
        val r = Random()
        val num1 = r.nextInt(10)
        var num2 = num1
        while (num2 == num1) {
            num2 = r.nextInt(10)
        }
        button1.text = "$num1"
        button2.text = "$num2"
    }

    private fun checkAnswer(isLeftButtonSelected: Boolean) {
        val n1 = button1.text.toString().toInt()
        val n2 = button2.text.toString().toInt()
        val isAnswerCorrect = if (isLeftButtonSelected) n1 > n2 else n2 > n1
        val toastMessage: String
        val backgroundColor: Int
        if (isAnswerCorrect) {
            toastMessage = "Correct!!"
            backgroundColor = Color.BLUE
        } else {
            toastMessage = "Wrong"
            backgroundColor = Color.RED
        }
        Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        backgroundview1.setBackgroundColor(backgroundColor)
    }
}