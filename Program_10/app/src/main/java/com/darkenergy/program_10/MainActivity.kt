package com.darkenergy.program_10

import android.content.ActivityNotFoundException
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText :  EditText
    private lateinit var send : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        send = findViewById(R.id.send)

        send.setOnClickListener {
            val intent  = Intent().apply {
                action =  Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT , editText.text.toString().trim())
                type = "text/plain"
            }

            try {
                startActivity(intent)
            }catch (e : ActivityNotFoundException ){
                Toast.makeText(this, "No Application found that can Handle this Request !!" , Toast.LENGTH_SHORT).show()
            }
        }
    }
}
