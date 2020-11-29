package com.example.workmanager_ontimeworkrequest

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import java.lang.Exception

class MyWork(c: Context, wp: WorkerParameters) : CoroutineWorker(c, wp) {

    override suspend fun doWork(): Result {

        try {
            var nm = NotificationManagerCompat.from(applicationContext)
            var n1 = NotificationCompat.Builder(applicationContext, App.id)

                .setContentTitle("helllo...")
                .setContentText("how are you dude there.......will you come to there....to have some things...")
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setContentIntent(
                    PendingIntent.getActivity(
                        applicationContext, 1,
                        Intent(applicationContext, MainActivity::class.java), 0
                    )
                )
                .setStyle(
                    NotificationCompat.BigTextStyle()
                        .setBigContentTitle("this is big content title")
                        .bigText(
                            "this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications this is bic text style , here you can add upto seve lines length of text. usually all the styles like bigtext,bigpicture,inbox are happens on exanded view of notifications"
                        )
                        .setSummaryText("user1")
                )
                .setColor(Color.RED)
                .setOnlyAlertOnce(true)

            nm.notify(1, n1.build())
            return Result.success()
        } catch (e: Exception) {
            return Result.failure()
        }


    }
}