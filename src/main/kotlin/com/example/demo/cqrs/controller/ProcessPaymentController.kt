package com.example.demo.cqrs.controller

import community.flock.wirespec.generated.endpoint.ProcessPayment
import community.flock.wirespec.generated.model.CartId
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.UUID

@RestController
class ProcessPaymentController(
    val commandGateway: CommandGateway,
) : ProcessPayment.Handler {
    override suspend fun processPayment(request: ProcessPayment.Request): ProcessPayment.Response<*> {
        commandGateway.send<ProcessPayment>(
            com.example.demo.cqrs.command.api.ProcessPayment(
                UUID.fromString(request.path.cartId),
                BigDecimal(request.body.amountPaid)
                    .setScale(2, RoundingMode.HALF_UP),
            ),
        )
        return ProcessPayment.Response200(CartId(request.path.cartId))
    }
}
