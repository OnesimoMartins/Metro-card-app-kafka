package com.metrocard.transportationservice.web.out

import com.metrocard.transportationservice.model.Card
import java.math.BigDecimal


data class CardOut(
    val id:Long,
    val amount:BigDecimal
){
    companion object
}

fun CardOut.Companion.fromCard(card:Card)=CardOut(id=card.id!!,amount=card.amount!!)