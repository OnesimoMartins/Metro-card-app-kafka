package com.metrocard.transportationservice.web.`in`

import com.metrocard.transportationservice.model.Card
import com.metrocard.transportationservice.model.Passenger
import com.metrocard.transportationservice.model.PassengerType

data class NewPassenger(
    val name:String,
    val lastName:String,
    val passengerType:PassengerType)

fun NewPassenger.toPassenger()=Passenger(
    id = null,
    name=this.name,
    lastName=this.lastName,
    passengerType=passengerType,
    card = Card(null,null)
)