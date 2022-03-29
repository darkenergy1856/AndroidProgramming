package com.darkenergy.program_2

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val increase = findViewById<Button>(R.id.increase)
        val decrease = findViewById<Button>(R.id.decrease)
        val reset = findViewById<Button>(R.id.reset)
        val textView = findViewById<TextView>(R.id.textView)

        increase.setOnClickListener {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textView.textSize + 10F)
        }

        decrease.setOnClickListener {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textView.textSize - 10F)
            if(textView.textSize < 10F)
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX , 0F)
        }

        reset.setOnClickListener {
            textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, 0F)
        }

    }
}