plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":common"))
}

tasks.bootJar {
    enabled = false
}
