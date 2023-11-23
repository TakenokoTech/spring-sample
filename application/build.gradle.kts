plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
    implementation(project(":domain"))
}

tasks.bootJar {
    enabled = false
}
