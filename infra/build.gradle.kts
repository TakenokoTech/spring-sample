plugins {
    kotlin("jvm")
}

dependencies {
    implementation("com.mysql:mysql-connector-j:8.2.0")
    implementation(project(":common"))
    implementation(project(":domain"))
}

tasks.bootJar {
    enabled = false
}
