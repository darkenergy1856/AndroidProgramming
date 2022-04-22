package com.darkenergy.program_14

import android.app.Service
import android.content.Intent
import android.os.*
import android.widget.Toast

open class ServiceClass : Service() {

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(this, "Service starting", Toast.LENGTH_SHORT).show()
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onDestroy() {
        Toast.makeText(this, "Service Stopped", Toast.LENGTH_SHORT).show()
        super.onDestroy()
    }
}