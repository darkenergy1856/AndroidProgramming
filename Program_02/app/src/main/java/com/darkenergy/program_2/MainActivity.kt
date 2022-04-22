package com.darkenergy.program_2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var data = 0

        val increase = findViewById<Button>(R.id.increase)
        val decrease = findViewById<Button>(R.id.decrease)
        val reset = findViewById<Button>(R.id.reset)
        val textView = findViewById<TextView>(R.id.textView)

        textView.textSize = 50F

        textView.text = "0"

        increase.setOnClickListener {
            data++
            val temp =  data.toString()
            textView.text = temp
        }

        decrease.setOnClickListener {
            data --
            val temp =  data.toString()
            textView.text = temp
        }

        reset.setOnClickListener {
            data = 0
            textView.text = "0"
        }

    }
}