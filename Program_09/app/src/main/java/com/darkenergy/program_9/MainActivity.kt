package com.darkenergy.program_9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentTransaction : FragmentTransaction = supportFragmentManager.beginTransaction()
        val changeForeground = ChangeForeground()
        fragmentTransaction.replace(R.id.frameChanger ,  changeForeground )
        fragmentTransaction.commit()
    }
}