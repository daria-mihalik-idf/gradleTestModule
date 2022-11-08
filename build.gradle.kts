import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("io.qameta.allure") version "2.9.6"
}

group = "me.dashiki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}


application {
    mainClass.set("MainKt")
}

tasks.register<Test>("someTestTask") {
    include("testTask/*")
}

tasks.register<Test>("failTest") {
    failFast = true
}

tasks.register<Test>("parallelTest") {
    maxParallelForks = 2
}

allure {
    adapter.autoconfigure
    adapter.aspectjWeaver
}