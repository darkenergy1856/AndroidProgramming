package com.darkenergy.program_12

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Receiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
            Toast.makeText(context, "Broadcast Received : ${intent?.extras?.get("data")}", Toast.LENGTH_SHORT).show()
    }
}
