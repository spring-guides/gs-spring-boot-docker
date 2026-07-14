package hello

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.http.HttpStatus
import org.springframework.test.annotation.DirtiesContext
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
class HelloWorldConfigurationTests {

	@LocalServerPort
	private var port: Int = 0

	private val restTemplate = RestTemplate()

	@Test
	fun testGreeting() {
		val entity = restTemplate.getForEntity<String>("http://localhost:$port/")
		assertEquals(HttpStatus.OK, entity.statusCode)
	}
}
