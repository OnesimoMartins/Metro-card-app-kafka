package com.metrocard.transportationservice.event

import java.time.LocalDateTime

data class NewPassengerEvent(val email:String, val name:String, val lastName:String)

data class NewTravelEvent(val trainId:Long,val from:Long,val to:Long)

data class TrainPositionEvent(val trainId:Long,val dateTime: LocalDateTime,val location:String)