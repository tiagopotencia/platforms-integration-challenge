package com.bemobi.test.bemobitest.controller

import com.bemobi.test.bemobitest.domain.IntegrationDto
import com.bemobi.test.bemobitest.service.IntegrationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/integration")
class IntegrationController @Autowired constructor(
        private val integrationService: IntegrationService
){

    @PostMapping("/")
    fun sendToQueue(@RequestBody(required = true) integrationDto: IntegrationDto) : ResponseEntity<*> {
        try {
            print("Message received: ${integrationDto}")
            integrationService.processMessage(integrationDto)
        } catch (e: NumberFormatException) {
            ResponseEntity.badRequest().body(mapOf("Message" to "The amount value must be a number"))
        } catch (e: Exception) {
            print("Error whem processing message ${integrationDto}. Error: ${e}")
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Message" to "We had a internal problem. Please, try again later.")
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(mapOf("Message" to "Message sent to queue successfully!"))
    }

}