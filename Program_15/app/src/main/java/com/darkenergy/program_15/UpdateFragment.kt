package com.darkenergy.program_15

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class UpdateFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.update , container , false)

        val create = view.findViewById<Button>(R.id.create_update)
        val update = view.findViewById<Button>(R.id.update_update)
        val viewButton = view.findViewById<Button>(R.id.view_update)
        val delete = view.findViewById<Button>(R.id.delete_update)
        val rollNo = view.findViewById<EditText>(R.id.rollNo_update)
        val name = view.findViewById<EditText>(R.id.name_update)

        create.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val createFragment = CreateFragment()
            fragmentTransaction.replace(R.id.frameLayout, createFragment)
            fragmentTransaction.commit()
        }

        update.setOnClickListener {
            val database = this.context?.let { it1 -> SqlClass(it1) }
            database!!.updateData(Integer.parseInt(rollNo.text.toString().trim()), name.text.toString().trim())
        }

        viewButton.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val viewFragment = ViewFragment()
            fragmentTransaction.replace(R.id.frameLayout, viewFragment)
            fragmentTransaction.commit()
        }

        delete.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val deleteFragment = DeleteFragment()
            fragmentTransaction.replace(R.id.frameLayout, deleteFragment)
            fragmentTransaction.commit()
        }




        val masterText = activity?.findViewById<TextView>(R.id.masterText)

        masterText?.text = getString(R.string.updateMode)
        return view
    }
}