package com.metrocard.transportationservice.utils.extension

import java.math.BigDecimal

fun BigDecimal.mutiply(int: Int):BigDecimal=this.multiply(BigDecimal(int))