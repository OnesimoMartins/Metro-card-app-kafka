package com.metrocard.transportationservice.web

import com.metrocard.transportationservice.event.NewPassengerEvent
import com.metrocard.transportationservice.kafka.Topic
import com.metrocard.transportationservice.service.PassengerService
import com.metrocard.transportationservice.web.`in`.NewPassenger
import com.metrocard.transportationservice.web.`in`.toPassenger
import com.metrocard.transportationservice.web.out.PassengerOut
import com.metrocard.transportationservice.web.out.fromPassenger
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("passengers")
class PassengerController(
   private val passengerService: PassengerService,
   private val kafkaTemplate: KafkaTemplate<String,Any>
) {

    @PostMapping
    fun createPassenger(@RequestBody newPassenger: NewPassenger):PassengerOut {
        return PassengerOut.fromPassenger {
           passengerService.createPassenger(newPassenger.toPassenger())
       }.also {
           kafkaTemplate.send(Topic.NEW_PASSENGER.get(), NewPassengerEvent(
               email = "onesimogouveiamartins@gmail.com", it.name, it.lastName))
       }
    }



}