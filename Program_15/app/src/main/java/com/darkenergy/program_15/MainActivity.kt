package com.darkenergy.program_15

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        val defaultFragment = ViewFragment()
        fragmentTransaction.replace(R.id.frameLayout, defaultFragment)
        fragmentTransaction.commit()
    }
}
