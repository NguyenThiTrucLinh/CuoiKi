package com.example.afinal

class Event{
    var nameEvent: String? = null
    var dateEvent: String? = null
    var timeEvent: String? = null
    var imageEvent: Int? = null

    constructor(nameEvent:String,  dateEvent: String, timeEvent: String, imageEvent: Int){
        this.nameEvent  = nameEvent
        this.dateEvent  = dateEvent
        this.timeEvent  = timeEvent
        this.imageEvent = imageEvent
    }

}
