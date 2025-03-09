package com.example.demo.cqrs.payment_command_model

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PaymentCommandModelApplication

fun main(args: Array<String>) {
	runApplication<PaymentCommandModelApplication>(*args)
}
