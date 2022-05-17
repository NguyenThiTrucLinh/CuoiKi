package com.example.afinal

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_event_info.*
import kotlinx.android.synthetic.main.activity_main2.*
import com.example.afinal.databinding.ActivityMainBinding

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.*

private val handler = Handler()
class MainActivity3 : AppCompatActivity() {
    @SuppressLint("SimpleDateFormat")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val demo:TextView = findViewById(R.id.demo)
        val bundle:Bundle = intent.extras!!
        val event =bundle.getString("event")
        val date = bundle.getString("date")
        val time = bundle.getString("time")
        tvName.text=event
        tvTime.text=time
        tvDate.text=date
        //.............................................................
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)
        val formatted = current.format(formatter)
       demo.text = formatted


    }

}