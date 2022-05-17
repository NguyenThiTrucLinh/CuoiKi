package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_event_info.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

class EventInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_event_info)
        val bundle:Bundle = intent.extras!!
        val name =bundle.getString("name")
        val date = bundle.getString("date")
        val time = bundle.getString("time")
        val image=bundle.getInt("image")
        //ivEventImage.setImageResource(image)
        tvName.text=name
        tvTime.text=time
        tvDate.text=date


    }

}