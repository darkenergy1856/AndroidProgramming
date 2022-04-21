package com.darkenergy.program_13

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

const val CHANNEL_ID = "com.darkenergy.program_13.customNotification"

class MainActivity : AppCompatActivity() {
    private lateinit var editNotification: EditText
    private lateinit var createNotification: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        editNotification = findViewById(R.id.editNotification)
        createNotification = findViewById(R.id.createNotifiaction)

        createNotification.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }
            val pendingIntent: PendingIntent = PendingIntent.getActivities(
                this, 0,
                arrayOf(intent), PendingIntent.FLAG_IMMUTABLE
            )
            var builder = NotificationCompat.Builder(this, CHANNEL_ID).setContentTitle("PROGRAM_13")
                .setContentText(editNotification.text.toString().trim())
                .setPriority(NotificationCompat.PRIORITY_MIN).setSmallIcon(R.drawable.ic_envelope)
                .setContentIntent(pendingIntent).setAutoCancel(true)

            NotificationManagerCompat.from(this).notify( 1 , builder.build())

        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name)
            val descriptionText = getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}