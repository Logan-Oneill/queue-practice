package com.queueservice.messagereader

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MessageReaderApplication

fun main(args: Array<String>) {
    runApplication<MessageReaderApplication>(*args)
}
