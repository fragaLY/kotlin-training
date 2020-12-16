import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}

group = "me.vadzim_kavalkou"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object DependencyVersions {
    const val JUNIT_VERSION = "5.7.0"
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:${DependencyVersions.JUNIT_VERSION}")
    testImplementation("org.junit.jupiter:junit-jupiter-params:${DependencyVersions.JUNIT_VERSION}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${DependencyVersions.JUNIT_VERSION}")
}

configurations {
    testImplementation {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

tasks {
    named<Test>("test") {
        testLogging.showExceptions = true
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
