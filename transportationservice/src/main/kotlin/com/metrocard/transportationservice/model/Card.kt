package com.metrocard.transportationservice.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.math.BigDecimal

@Entity
data class Card(
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    val id:Long?,
    var amount:BigDecimal?
    )