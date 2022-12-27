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

fun PassengerOut.Companion.fromPassenger(passenger: Passenger)=PassengerOut(
    id=passenger.id!!,
    name=passenger.name,
    lastName=passenger.lastName,
    passengerType = passenger.passengerType,
    card = CardOut.fromCard(passenger.card!!),
)