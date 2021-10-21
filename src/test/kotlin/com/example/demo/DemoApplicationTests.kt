package com.example.demo

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.KafkaContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers
import org.testcontainers.utility.DockerImageName

@SpringBootTest
@Testcontainers
class DemoApplicationTests {

	companion object {
		@Container
		private val kafkaContainer: KafkaContainer =
			KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"))

		@JvmStatic
		@DynamicPropertySource
		fun properties(registry: DynamicPropertyRegistry) {
			registry.add("spring.kafka.bootstrapServers", kafkaContainer::getBootstrapServers)
		}
	}

	@Test
	fun contextLoads() {
	}

}
