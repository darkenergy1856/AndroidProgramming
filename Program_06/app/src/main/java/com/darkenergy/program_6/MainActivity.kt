//Create a list of all courses in your college and on selecting a particular course teacher-in charge
//of that course should appear at the bottom of the screen.

package com.darkenergy.program_6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.textView)
        val list = findViewById<ListView>(R.id.list)

        val coursesList =
            arrayOf("Computer Science", "Mathematics", "Food Technology", "Biomedical")

        val adapter: ArrayAdapter<String> =
            ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, coursesList)

        list.adapter = adapter

        textView.text = getString(R.string.initialText)

        list.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            when (position) {
                0 -> {
                    textView.text = getString(R.string.computerScience)
                }
                1 -> {
                    textView.text = getString(R.string.Mathematics)
                }
                2 -> {
                    textView.text = getString(R.string.FoodTechnology)
                }
                3 -> {
                    textView.text = getString(R.string.BioMedical)
                }
                else -> {
                    Toast.makeText(this, "Unknown Position Received", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}
