package com.darkenergy.program_11

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val textView: TextView = findViewById(R.id.textView)
        val logout: Button = findViewById(R.id.logout)
        val dialogueBuilder = AlertDialog.Builder(this)

        val userNameReceived = "Welcome " + intent.getStringExtra(EXTRA_MESSAGE)

        textView.text = userNameReceived

        logout.setOnClickListener {
            dialogueBuilder.setMessage(R.string.confirm_logout_message)
                .setTitle(R.string.confirm_logout).setCancelable(false)
                .setPositiveButton("Yes", DialogInterface.OnClickListener { _, _ ->
                    val intent = Intent(this, MainActivity::class.java)
                    finish()
                    Toast.makeText(this, "Logout Successful !!", Toast.LENGTH_SHORT).show()
                    startActivity(intent)
                }).setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, _ ->
                dialogInterface.cancel()
                    Toast.makeText(this, "Operation Canceled" , Toast.LENGTH_SHORT).show()
            })

            val alert : AlertDialog = dialogueBuilder.create()
            alert.setTitle(R.string.confirm_logout)
            alert.show()

        }


    }
}