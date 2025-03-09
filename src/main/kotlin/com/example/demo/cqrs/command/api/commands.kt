package com.example.demo.cqrs.command.api

import org.axonframework.modelling.command.TargetAggregateIdentifier
import java.math.BigDecimal
import java.util.*

data class ProcessPayment(
    @TargetAggregateIdentifier
    val cartId: UUID,
    val amountPaid: BigDecimal,
)
