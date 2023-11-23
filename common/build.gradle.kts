plugins {
    kotlin("jvm")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web")
    api("org.springframework.boot:spring-boot-starter-data-jpa")
}

tasks.bootJar {
    enabled = false
}
