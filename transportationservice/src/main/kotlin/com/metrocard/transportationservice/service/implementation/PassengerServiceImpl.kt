package com.metrocard.transportationservice.service.implementation

import com.metrocard.transportationservice.model.Passenger
import com.metrocard.transportationservice.repository.CardRepository
import com.metrocard.transportationservice.repository.PassengerRepository
import com.metrocard.transportationservice.service.PassengerService
import org.springframework.stereotype.Service
import java.math.BigDecimal

@Service
class PassengerServiceImpl(
    val passengerRepository: PassengerRepository,
    val cardRepository: CardRepository
):PassengerService {

    override fun createPassenger(passenger: Passenger): Passenger{

        passenger.card.amount= BigDecimal.ZERO

        return cardRepository.save(passenger.card).let {
           passenger.card=it
          passengerRepository.save(passenger)
        }
    }

}