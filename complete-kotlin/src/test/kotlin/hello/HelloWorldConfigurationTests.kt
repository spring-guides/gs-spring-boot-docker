package hello

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.test.web.servlet.client.RestTestClient
import org.springframework.test.web.servlet.client.expectBody

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HelloWorldConfigurationTests(@Autowired private val restTestClient: RestTestClient) {

    @Test
    fun testGreeting() {
        restTestClient.get()
            .uri("/")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .isEqualTo("Hello Docker World")
    }
}
