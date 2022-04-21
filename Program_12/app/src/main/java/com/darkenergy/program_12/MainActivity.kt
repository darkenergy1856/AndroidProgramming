package com.darkenergy.program_12


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var send: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        send = findViewById(R.id.send)
        send.setOnClickListener {
            Intent(this, Receiver::class.java).also { intent ->
                run {
                    intent.action = "com.darkenergy.program_12"
                    intent.putExtra("data", "This is Broadcast")
                    sendBroadcast(intent)
                }
            }
        }
    }
}