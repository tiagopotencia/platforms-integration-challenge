package com.bemobi.test.bemobitest

import com.bemobi.test.bemobitest.domain.IntegrationDto
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.*


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BemobitestApplicationTests {

	@LocalServerPort
	private var port = 0

	val headers = HttpHeaders()
	val restTemplate = TestRestTemplate()


	private fun createURLWithPort(uri: String): String? {
		return "http://localhost:" + port.toString() + uri
	}

	@Test
	fun `Deve eniar para API e retornar 201`() {

		val integrationDto = IntegrationDto("id", "100")

		val entity = HttpEntity<IntegrationDto>(integrationDto, headers)

		val response: ResponseEntity<String> = restTemplate.exchange(
				createURLWithPort("/integration/"),
				HttpMethod.POST, entity, String::class.java)

		val statusCode = response.statusCode

		Assertions.assertEquals(HttpStatus.CREATED, statusCode)

	}

	@Test
	fun `Deve eniar para API e retornar 400`() {

		val integrationDto = IntegrationDto("id", "aa")

		val entity = HttpEntity<IntegrationDto>(integrationDto, headers)

		val response: ResponseEntity<String> = restTemplate.exchange(
				createURLWithPort("/integration/"),
				HttpMethod.POST, entity, String::class.java)

		val statusCode = response.statusCode

		Assertions.assertEquals(HttpStatus.BAD_REQUEST, statusCode)

	}

}
