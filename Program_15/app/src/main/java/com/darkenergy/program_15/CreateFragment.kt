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

open class CreateFragment : Fragment(R.layout.create) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.create, container, false)

        val create = view.findViewById<Button>(R.id.create_create)
        val delete = view.findViewById<Button>(R.id.delete_create)
        val update = view.findViewById<Button>(R.id.update_create)
        val viewButton = view.findViewById<Button>(R.id.view_create)
        val rollNo = view.findViewById<EditText>(R.id.rollNo_create)
        val name = view.findViewById<EditText>(R.id.name_create)
        val masterText = activity?.findViewById<TextView>(R.id.masterText)

        masterText?.text = getString(R.string.createMode)

        viewButton.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val viewFragment = ViewFragment()
            fragmentTransaction.replace(R.id.frameLayout, viewFragment)
            fragmentTransaction.commit()
        }

        create.setOnClickListener {
            val database = this.context?.let { it1 -> SqlClass(it1) }
            database!!.addData(Integer.parseInt(rollNo.text.toString().trim()), name.text.toString().trim() )
        }

        delete.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val deleteFragment = DeleteFragment()
            fragmentTransaction.replace(R.id.frameLayout, deleteFragment)
            fragmentTransaction.commit()
        }

        update.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val updateFragment = UpdateFragment()
            fragmentTransaction.replace(R.id.frameLayout, updateFragment)
            fragmentTransaction.commit()
        }
        return view
    }
}