package com.example.demo.cqrs.config

import org.axonframework.commandhandling.CommandBus
import org.axonframework.messaging.interceptors.LoggingInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration

@Configuration
class AxonConfig {
    @Autowired
    fun configureCommandBus(commandBus: CommandBus): CommandBus {
        commandBus.registerDispatchInterceptor(LoggingInterceptor())
        return commandBus
    }
}
