package com.darkenergy.program_5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        textView.text = getString(R.string.defaultValue)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item1 -> {
                textView.text = item.title
                return true
            }
            R.id.item2 -> {
                textView.text = item.title
                return true
            }
            R.id.item3 -> {
                textView.text = item.title
                return true
            }
            R.id.item4 -> {
                textView.text = item.title
                return true
            }
            R.id.item5 -> {
                textView.text = item.title
                return true
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
    }
}