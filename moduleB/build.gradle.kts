plugins {
    kotlin("jvm") version "1.7.10"
}

group = "me.dashiki"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(project(":moduleA"))
}