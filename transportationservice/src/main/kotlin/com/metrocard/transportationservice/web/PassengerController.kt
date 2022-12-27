package com.metrocard.transportationservice.web

import com.metrocard.transportationservice.service.PassengerService
import com.metrocard.transportationservice.web.`in`.NewPassenger
import com.metrocard.transportationservice.web.`in`.toPassenger
import com.metrocard.transportationservice.web.out.PassengerOut
import com.metrocard.transportationservice.web.out.fromPassenger
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("passengers")
class PassengerController(
   private val passengerService: PassengerService
) {

    @PostMapping
    fun createPassenger(@RequestBody newPassenger: NewPassenger):PassengerOut {
       return PassengerOut.fromPassenger(
                  passengerService.createPassenger(
                           newPassenger.toPassenger()
                   )
               )
    }

}