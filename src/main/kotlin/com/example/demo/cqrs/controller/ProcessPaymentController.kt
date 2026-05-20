package com.example.demo.cqrs.controller

import community.flock.wirespec.generated.endpoint.ProcessPaymentEndpoint
import community.flock.wirespec.generated.model.CartId
import community.flock.wirespec.generated.model.ProcessPayment
import org.axonframework.commandhandling.gateway.CommandGateway
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.UUID

@RestController
class ProcessPaymentController(
    val commandGateway: CommandGateway,
) : ProcessPaymentEndpoint.Handler {
    override suspend fun processPaymentEndpoint(request: ProcessPaymentEndpoint.Request): ProcessPaymentEndpoint.Response<*> {
        commandGateway.send<ProcessPayment>(
            com.example.demo.cqrs.command.api.ProcessPayment(
                UUID.fromString(request.path.cartId),
                BigDecimal(request.body.amountPaid)
                    .setScale(2, RoundingMode.HALF_UP),
            ),
        )
        return ProcessPaymentEndpoint.Response200(CartId(request.path.cartId))
    }
}
