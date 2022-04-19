package com.darkenergy.program_9

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

open class ChangeForeground : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view  = inflater.inflate(R.layout.change_foreground , container , false)

        val textView = activity?.findViewById<TextView>(R.id.textView)
        val changeFragment = view.findViewById<Button>(R.id.changeFragment)
        val changeForeground = view.findViewById<Button>(R.id.foreGround)
        val reset = view.findViewById<Button>(R.id.reset)

        changeForeground.setOnClickListener {

            textView?.setTextColor(resources.getColor(R.color.Blue))
        }

        changeFragment.setOnClickListener {
            val fragmentTransaction : FragmentTransaction = parentFragmentManager.beginTransaction()
            val changeBackground = ChangeBackground()
            fragmentTransaction.replace(R.id.frameChanger ,  changeBackground)
            fragmentTransaction.commit()
        }

        reset.setOnClickListener { textView?.setTextColor(Color.BLACK) }

        return view
    }
}