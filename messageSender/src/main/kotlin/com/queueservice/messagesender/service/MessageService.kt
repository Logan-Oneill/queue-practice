package com.queueservice.messagesender.service

import com.queueservice.messagesender.models.EnqueueMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessageService {

    private val logger: Logger = LoggerFactory.getLogger(MessageService::class.java)

    fun receiveMessage(enqueueMessage: EnqueueMessage): EnqueueResponse {
        logger.info("Received message: ${enqueueMessage.name}")
        return EnqueueResponse.Success("message received: ${enqueueMessage.name}")
    }

    sealed interface EnqueueResponse {
        data class Success(val message: String) : EnqueueResponse
        data class Failure(val error: String) : EnqueueResponse
    }
}