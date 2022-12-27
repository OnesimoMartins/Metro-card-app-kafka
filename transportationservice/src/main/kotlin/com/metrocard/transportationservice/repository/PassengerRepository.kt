package com.metrocard.transportationservice.repository

import com.metrocard.transportationservice.model.Passenger
import org.springframework.data.jpa.repository.JpaRepository

interface PassengerRepository:JpaRepository<Passenger,Long>