package com.metrocard.transportationservice.repository

import com.metrocard.transportationservice.model.Card
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository:JpaRepository<Card,Long>