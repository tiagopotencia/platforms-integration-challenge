package com.bemobi.test.bemobitest

import com.bemobi.test.bemobitest.domain.IntegrationDto
import com.bemobi.test.bemobitest.service.IntegrationService
import com.bemobi.test.bemobitest.service.QueueService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mockito
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class IntegrationSericeUnitTests {

    val queueServiceMock = Mockito.mock(QueueService::class.java)

    @InjectMocks
    lateinit var integrationSerice: IntegrationService

    @Test
    fun `Deve transformar IntegrationDto no DTO Final`() {

        val integrationDto = IntegrationDto("8bac677a-1078-4a4d-b8ba-2877b52944ad", "900")

        Mockito.doNothing().`when`(queueServiceMock).send(anyObject())

        assertDoesNotThrow {integrationSerice.processMessage(integrationDto)}

        Mockito.verify(queueServiceMock, Mockito.atMostOnce()).send(anyObject())
    }

    @Test
    fun `Deve transformar IntegrationDto no DTO Final exceptop`() {

        val integrationDto = IntegrationDto("8bac677a-1078-4a4d-b8ba-2877b52944ad", "abc")

        assertThrows<Exception> {integrationSerice.processMessage(integrationDto)}
        Mockito.verifyNoInteractions(queueServiceMock)

    }

    private fun <T> anyObject(): T {
        return Mockito.any()
    }
}