package com.metrocard.transportationservice.service

import com.metrocard.transportationservice.model.Passenger

interface PassengerService {
    fun createPassenger(passenger: Passenger):Passenger;
}
