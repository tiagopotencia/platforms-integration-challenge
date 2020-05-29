package com.bemobi.test.bemobitest.service

import com.bemobi.test.bemobitest.domain.TransformedDto
import com.google.gson.Gson
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.sqs.SqsClient
import software.amazon.awssdk.services.sqs.model.SendMessageRequest
import java.net.URI

@Service
class QueueService (
    @Value("\${sqs.url}")
    private val sqsUrl: String,

    @Value("\${sqs.queueUrl}")
    private val sqsQueueUrl: String
) {
    private var sqsClient = SqsClient.builder()
            .endpointOverride(URI.create(sqsUrl))
            .build()

    fun send(transformedDto: TransformedDto) {
        val jsonMessage = Gson().toJson(transformedDto)

        sqsClient.sendMessage(SendMessageRequest.builder()
                .queueUrl(sqsQueueUrl)
                .messageBody(jsonMessage)
                .delaySeconds(10)
                .build())

        println("Message: ${jsonMessage} inserted successfully!")
    }
}