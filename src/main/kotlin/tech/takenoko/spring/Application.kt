package tech.takenoko.spring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories(considerNestedRepositories = true)
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}
