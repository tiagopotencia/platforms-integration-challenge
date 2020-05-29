package com.bemobi.test.bemobitest.service

import com.bemobi.test.bemobitest.domain.TransformedDto
import com.bemobi.test.bemobitest.domain.IntegrationDto
import com.bemobi.test.bemobitest.domain.IntegrationStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.math.BigDecimal
import java.time.LocalDateTime


@Service
class IntegrationService @Autowired constructor(val queueService: QueueService){

    fun processMessage(integrationDto: IntegrationDto) {
        val finalDto = trasnformDto(integrationDto)
        queueService.send(finalDto)
    }

    private fun trasnformDto(integrationDto: IntegrationDto) : TransformedDto {

        val finalAmount = integrationDto.amount.toBigDecimal().divide(BigDecimal(10000))

        val finalDto = TransformedDto(integrationDto.productId, finalAmount, IntegrationStatus.ACTIVE, LocalDateTime.now())

        return finalDto
    }

}