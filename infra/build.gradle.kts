plugins {
    kotlin("jvm")
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.netty:netty-resolver-dns-native-macos:4.1.101.Final:osx-aarch_64")
    implementation("com.mysql:mysql-connector-j:8.2.0")
    implementation(project(":common"))
    implementation(project(":domain"))
}

tasks.bootJar {
    enabled = false
}
