package com.darkenergy.program_3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val userName = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val pass = findViewById<EditText>(R.id.editTextNumberPassword)
        val statusText = findViewById<TextView>(R.id.status)
        var loginStatus = false

        val store :MutableMap<String , String> = mutableMapOf("aryanchandra7360@gmail.com" to  "aryanchandra7360@gmail.com")
        store["deepakkumar1811@gmail.com"] = "deepakIsSleeping"
        store["amantripathi@gmail.com"] = "amanTripathiIsSitting"
        loginButton.setOnClickListener {
            var emailId = userName.text.toString().trim()
            var password  = pass.text.toString().trim()
            for(key in store.keys){
                if(key == emailId) {
                    if (store[key] == password) {
                        loginStatus = true
                        break
                    }
                }else{
                    loginStatus = false
                }
            }
            if(loginStatus) {
                statusText.text = "Login Status : Verified"
                statusText.setTextColor(Color.BLUE)
            }else{
                statusText.text = "Login Status : Not Verified"
                statusText.setTextColor(Color.RED)
            }

        }

    }

    }