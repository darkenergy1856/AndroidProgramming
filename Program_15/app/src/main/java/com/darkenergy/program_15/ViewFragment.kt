package com.darkenergy.program_15

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

open class ViewFragment : Fragment(R.layout.view) {
    @SuppressLint("Range")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.view, container, false)
        val update = view.findViewById<Button>(R.id.update)
        val create = view.findViewById<Button>(R.id.create)
        val delete = view.findViewById<Button>(R.id.delete)
        val listDetail = view.findViewById<ListView>(R.id.listDetails)
        val masterText = activity?.findViewById<TextView>(R.id.masterText)

        masterText?.text = getString(R.string.viewMode)

        val database = context?.let { SqlClass(it) }
        val result  = database?.viewData()

        val resultList : MutableList<String> = ArrayList()
        resultList.add("Result List")

        result!!.moveToFirst()
        while (result.moveToNext()){
            resultList.add("${result.getString(result.getColumnIndex("rollNo"))} : ${result.getString(result.getColumnIndex("name"))}")
        }
        val context = context
        val adapter =
            context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1 , resultList ) }

        listDetail.adapter = adapter


        update.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val updateFragment = UpdateFragment()
            fragmentTransaction.replace(R.id.frameLayout, updateFragment)
            fragmentTransaction.commit()
        }

        create.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val createFragment = CreateFragment()
            fragmentTransaction.replace(R.id.frameLayout, createFragment)
            fragmentTransaction.commit()
        }

        delete.setOnClickListener {
            val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            val deleteFragment = DeleteFragment()
            fragmentTransaction.replace(R.id.frameLayout, deleteFragment)
            fragmentTransaction.commit()
        }

        return view
    }
}