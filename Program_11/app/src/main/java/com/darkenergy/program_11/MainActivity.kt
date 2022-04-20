package com.darkenergy.program_11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.darkenergy.program_11"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val loginButton = findViewById<Button>(R.id.loginButton)
        val userName = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val pass = findViewById<EditText>(R.id.password)
        var loginStatus = false

        val store: MutableMap<String, String> =
            mutableMapOf("aryanchandra7360@gmail.com" to "aryanchandra7360@gmail.com")
        store["deepakkumar1811@gmail.com"] = "deepakIsSleeping"
        store["amantripathi@gmail.com"] = "amanTripathiIsSitting"
        loginButton.setOnClickListener {
            val emailId = userName.text.toString().trim()
            val password = pass.text.toString().trim()
            for (key in store.keys) {
                if (key == emailId) {
                    if (store[key] == password) {
                        loginStatus = true
                        break
                    }
                } else {
                    loginStatus = false
                }
            }
            if (loginStatus) {
                val intent = Intent(this,MainActivity2::class.java).apply {
                    putExtra(EXTRA_MESSAGE,emailId)
                }
                startActivity(intent)
            }else
                Toast.makeText(this , "Invalid User Name or Password " , Toast.LENGTH_SHORT).show()
        }
    }
}