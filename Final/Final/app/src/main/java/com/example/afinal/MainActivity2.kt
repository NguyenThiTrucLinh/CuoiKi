package com.example.afinal

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.view.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var tvEvent: TextInputLayout = findViewById(R.id.textInputLayout_event)
        var tvDescribe: TextInputLayout = findViewById(R.id.textInputLayout_describe)
        var btndate: ImageButton = findViewById(R.id.btn_date)
        var btntime: ImageButton = findViewById(R.id.btntime)
        var tvdate: TextView = findViewById(R.id.tvdate)
        btndate.setOnClickListener(View.OnClickListener { ChonNgay() })
        btntime.setOnClickListener(View.OnClickListener { ChonGio() })
        btnSave.setOnClickListener({CoundownEvent()})


    }
    private fun CoundownEvent(){
        var tvdate: TextView = findViewById(R.id.tvdate)
        var tvSukien: EditText = findViewById(R.id.tvSukien)
        var tvtime: TextView = findViewById(R.id.tvtime)
        val event = tvSukien.text.toString()
        val date = tvdate.text.toString()
        val time = tvtime.text.toString()
        val intent: Intent = Intent(this,MainActivity3::class.java)
        intent.putExtra("event",event)
        intent.putExtra("date",date)
        intent.putExtra("time",time)
        startActivity(intent)


    }

    private fun ChonNgay() {
        var tvdate: TextView = findViewById(R.id.tvdate)
        val calendar = Calendar.getInstance()
        val ngay = calendar[Calendar.DATE]
        val thang = calendar[Calendar.MONTH]
        val nam = calendar[Calendar.YEAR]
        val datePickerDialog = DatePickerDialog(this,
            { datePicker, i, i1, i2 ->
                calendar[i, i1] = i2
                val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy")
                tvdate.setText(simpleDateFormat.format(calendar.time))
            }, nam, thang, ngay)
        datePickerDialog.show()
    }
    private fun ChonGio() {
        val calendar = Calendar.getInstance()
        val gio = calendar[Calendar.HOUR_OF_DAY]
        val phut = calendar[Calendar.MINUTE]
        val timePickerDialog = TimePickerDialog(this,
            { timePicker, i, i1 ->
                val simpleDateFormat = SimpleDateFormat("HH:mm:ss")
                calendar[0, 0, 0, i] = i1
                tvtime.setText(simpleDateFormat.format(calendar.time))
            }, gio, phut, true)
        timePickerDialog.show()

    }
}
