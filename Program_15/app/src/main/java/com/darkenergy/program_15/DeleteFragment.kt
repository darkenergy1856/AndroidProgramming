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

class DeleteFragment : Fragment(R.layout.delete) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.delete, container, false)
        val masterText = activity?.findViewById<TextView>(R.id.masterText)
        val delete = view.findViewById<Button>(R.id.delete_delete)
        val create = view.findViewById<Button>(R.id.create_delete)
        val update = view.findViewById<Button>(R.id.update_delete)
        val viewButton = view.findViewById<Button>(R.id.view_delete)
        val rollNo = view.findViewById<EditText>(R.id.rollNo_delete)

        delete.setOnClickListener {
            val database = this.context?.let { it1 -> SqlClass(it1) }
            database?.deleteData(Integer.parseInt(rollNo.text.toString().trim()))
            rollNo.text.clear()
        }

        create.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val createFragment = CreateFragment()
            fragmentTransaction.replace(R.id.frameLayout, createFragment)
            fragmentTransaction.commit()
        }

        update.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val updateFragment = UpdateFragment()
            fragmentTransaction.replace(R.id.frameLayout, updateFragment)
            fragmentTransaction.commit()
        }

        viewButton.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val viewFragment = ViewFragment()
            fragmentTransaction.replace(R.id.frameLayout, viewFragment)
            fragmentTransaction.commit()
        }

        masterText?.text = getString(R.string.deleteMode)
        return view
    }
}