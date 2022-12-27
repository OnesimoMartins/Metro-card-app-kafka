package com.metrocard.transportationservice.model

import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToOne

@Entity
data class Passenger(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long?,
    val name:String,
    val lastName:String,
    @Enumerated(EnumType.STRING)
    val passengerType: PassengerType,
    @OneToOne
    var card: Card
    )

enum class PassengerType { CHILDREN,SENIOR,ADULT }