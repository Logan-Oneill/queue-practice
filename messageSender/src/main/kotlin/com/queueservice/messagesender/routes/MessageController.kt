package com.queueservice.messagesender.routes

import com.queueservice.messagesender.models.EnqueueMessage
import com.queueservice.messagesender.models.EnqueueMessageRequest
import com.queueservice.messagesender.models.EnqueueMessageResponse
import com.queueservice.messagesender.service.MessageService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/enqueueMessage")
class MessageController(
    val messageService: MessageService
) {

    @PostMapping
    fun enqueueMessage(@RequestBody enqueueMessageRequest: EnqueueMessageRequest): EnqueueMessageResponse {
        // Logic to enqueue the message
        // This is a placeholder implementation
        return when (messageService.receiveMessage(EnqueueMessage(enqueueMessageRequest.name))) {
            is MessageService.EnqueueResponse.Success -> EnqueueMessageResponse("Message enqueued successfully: ${enqueueMessageRequest.name}")
            is MessageService.EnqueueResponse.Failure -> EnqueueMessageResponse("Failed to enqueue message: ${enqueueMessageRequest.name}")
        }
    }
}