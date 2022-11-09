plugins {
    kotlin("jvm") version "1.7.10"
    application
    id("io.qameta.allure") version "2.9.6"
}
group = "me.dashiki"
version = "1.0-SNAPSHOT"
allure {
    adapter.autoconfigure
    adapter.aspectjWeaver
}

allprojects {
    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        val implementation by configurations
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.7.10")
    }
    tasks.test {
        useJUnitPlatform()
    }
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
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
}