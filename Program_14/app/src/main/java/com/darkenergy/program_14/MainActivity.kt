package com.darkenergy.program_14

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/*
* Create an application to create services.
*/

class MainActivity : AppCompatActivity() {
    private lateinit var startServiceButton : Button
    private lateinit var textBox : TextView
    private lateinit var stopServiceButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startServiceButton = findViewById(R.id.button)
        textBox = findViewById(R.id.countDown)
        stopServiceButton = findViewById(R.id.stopCount)

        val intent = Intent(this,ServiceClass::class.java)

        startServiceButton.setOnClickListener {
            startService(intent)
        }

        stopServiceButton.setOnClickListener {
            stopService(intent)
        }

    }
}