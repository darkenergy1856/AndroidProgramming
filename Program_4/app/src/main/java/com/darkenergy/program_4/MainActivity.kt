package com.darkenergy.program_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)
        val spinner = findViewById<Spinner>(R.id.spinner)

        val listItems = resources.getStringArray(R.array.listItems)

        if (spinner != null) {
            val adapter = ArrayAdapter(
                this,
                android.R.layout.simple_spinner_dropdown_item, listItems
            )
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    if (listItems[position] == "Flower")
                        imageView.setImageResource(R.drawable.flower)
                    if (listItems[position] == "Landscape")
                        imageView.setImageResource(R.drawable.landscape)
                    if (listItems[position] == "Anime")
                        imageView.setImageResource(R.drawable.anime)
                    if (listItems[position] == "Animal")
                        imageView.setImageResource(R.drawable.animal)
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                }
            }
        }
    }
}