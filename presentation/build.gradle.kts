plugins {
    kotlin("jvm")
}

dependencies {
    implementation("ch.qos.logback:logback-access:1.4.11")
    implementation(project(":application"))
    implementation(project(":common"))
    implementation(project(":domain"))
}

tasks.bootJar {
    enabled = false
}
