package com.example.afinal


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_one_event.view.*
import kotlinx.android.synthetic.main.row_one_event.view.tvDate
import kotlinx.android.synthetic.main.row_one_event.view.tvName
import kotlinx.android.synthetic.main.row_one_event.view.tvTime



class MainActivity : AppCompatActivity() {

    var listView = ArrayList<Event>()
    var adapter:EventAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load  animals
        listView.add(
            Event("Quốc tế thiếu nhi","01/06/2022","00:00",R.drawable.img))
        listView.add(
            Event("Quốc Khánh Việt Nam","02/09/2022","00:00",R.drawable.img_1))
        listView.add(
            Event("Nhà giáo Việt Nam","20/11/2022","00:00",R.drawable.img_2))

        adapter = EventAdapter(this,listView)
        listOf_event.adapter =  adapter
        btn_chuyen.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        btn_countdown.setOnClickListener{
            val intent: Intent = Intent(this,MainActivity4::class.java)
            startActivity(intent)
        }



    }



    inner class  EventAdapter:BaseAdapter {
        var  listView= ArrayList<Event>()
        var context:Context?=null
        constructor(context:Context, listOfAnimals: ArrayList<Event>):super(){
            this.listView=listOfAnimals
            this.context=context
        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val event =  listView[p0]
            var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflator.inflate(R.layout.row_one_event, null)
            myView.tvName.text = event.nameEvent!!
            myView.tvDate.text = event.dateEvent!!
            myView.tvTime.text = event.timeEvent!!
            myView.ivEventImage.setImageResource(event.imageEvent!!)
            myView.ivEventImage.setOnClickListener {
                val intent = Intent(context,EventInfo::class.java)
                intent.putExtra("name",event.nameEvent!!)
                intent.putExtra("date",event.dateEvent!!)
                intent.putExtra("time",event.timeEvent!!)
                intent.putExtra("image",event.imageEvent!!)
                context!!.startActivity(intent)
            }
            return myView

        }


        override fun getItem(p0: Int): Any {
            return listView[p0]
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {

            return  listView.size
        }

    }
}