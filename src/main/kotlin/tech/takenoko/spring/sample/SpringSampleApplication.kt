package tech.takenoko.spring.sample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSampleApplication

fun main(args: Array<String>) {
    runApplication<SpringSampleApplication>(*args)
}
