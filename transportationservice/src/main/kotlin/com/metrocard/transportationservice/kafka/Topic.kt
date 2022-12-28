package com.metrocard.transportationservice.kafka

enum class Topic {

    NEW_PASSENGER{
        override fun toString()= "public.passenger.newpassenger"
     },
    TRAIN_POSITION{
        override fun toString()= "private.train.trainposition"
    },
    CHECK_IN{
        override fun toString()= "private.travel.checkin"
    },
    CARD_OPERATION{
        override fun toString()= "public.card.cardoperation"
    };

    fun get()=this.toString()

}