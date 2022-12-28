package com.metrocard.transportationservice.web.out

import com.metrocard.transportationservice.model.Passenger
import com.metrocard.transportationservice.model.PassengerType

data class PassengerOut(
    val id:Long,
    val name:String,
    val lastName:String,
    val passengerType: PassengerType,
    val card: CardOut
){
    companion object
}

fun PassengerOut.Companion.fromPassenger(passenger:()->Passenger)=passenger.invoke().let{
    PassengerOut(
    id=it.id!!,
    name=it.name,
    lastName=it.lastName,
    passengerType = it.passengerType,
    card = CardOut.fromCard(it.card)
    )
}