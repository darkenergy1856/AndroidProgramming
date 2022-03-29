package com.darkenergy.program_7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioGroup
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {

    private lateinit var constraintLayout: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        constraintLayout = findViewById(R.id.testLayout)

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)

        radioGroup.setOnCheckedChangeListener { _, radioButtonId ->
            run {
                when (radioButtonId) {
                    R.id.Peach_Crayola -> {
                        constraintLayout.setBackgroundColor(resources.getColor(R.color.Peach_Crayola))
                    }
                    R.id.Old_Lavender -> {
                        constraintLayout.setBackgroundColor(resources.getColor(R.color.Old_Lavender))
                    }
                    R.id.Antique_Fuchsia -> {
                        constraintLayout.setBackgroundColor(resources.getColor(R.color.Antique_Fuchsia))
                    }
                }
            }
        }

    }
}
