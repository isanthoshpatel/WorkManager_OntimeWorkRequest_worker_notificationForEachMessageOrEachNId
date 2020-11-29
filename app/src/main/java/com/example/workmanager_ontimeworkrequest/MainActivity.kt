package com.example.workmanager_ontimeworkrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bt_mywork.setOnClickListener {
            i++
            var owr = OneTimeWorkRequest
                .Builder(MyWork::class.java)
                .setInputData(Data.Builder().putInt("i", i).build())
                .setConstraints(
                    Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()
                )
                .build()

            WorkManager.getInstance(this).enqueue(owr)

            WorkManager.getInstance(applicationContext).getWorkInfoByIdLiveData(owr.id)
                .observe(this, {
                    textView.text = it.state.toString()
                })
        }
    }
}