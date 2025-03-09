package com.example.demo.cqrs

import community.flock.wirespec.integration.spring.kotlin.configuration.EnableWirespecController
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableWirespecController
class PaymentCommandModelApplication

fun main(args: Array<String>) {
    runApplication<PaymentCommandModelApplication>(*args)
}
