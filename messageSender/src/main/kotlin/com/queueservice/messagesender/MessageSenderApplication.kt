package com.queueservice.messagesender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MessageSenderApplication

fun main(args: Array<String>) {
    runApplication<MessageSenderApplication>(*args)
}
