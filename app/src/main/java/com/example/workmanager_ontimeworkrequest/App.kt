package com.example.workmanager_ontimeworkrequest

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

class App : Application() {
    companion object {
        val id = "Channel1"
    }

    override fun onCreate() {
        super.onCreate()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            var nch1 = NotificationChannel(id, id, NotificationManager.IMPORTANCE_HIGH)

            var nm = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            nm.createNotificationChannel(nch1)

        }


    }
}