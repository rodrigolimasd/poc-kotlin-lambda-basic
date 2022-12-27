import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar
import com.github.jengelman.gradle.plugins.shadow.transformers.Log4j2PluginsCacheFileTransformer

plugins {
    id("maven-publish")
    id("java")
    id("io.spring.dependency-management") version "1.0.9.RELEASE"
    id("org.jetbrains.kotlin.jvm") version "1.3.71"
    id("com.github.johnrengelman.shadow") version "6.0.0"
    application
}

group = "com.rodtech"
version = "dev"
description = "Kotlin Poc Basic Lambda"

java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.3.72")
    implementation("com.amazonaws:aws-lambda-java-core:1.2.1")
    implementation("com.amazonaws:aws-lambda-java-log4j2:1.5.1")
    implementation("org.apache.logging.log4j:log4j-api:2.17.1")
    implementation("org.apache.logging.log4j:log4j-core:2.17.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.11.0")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.11.0")
}

tasks.register("deploy", Exec::class.java) {
    dependsOn("shadowJar")
    commandLine("serverless","deploy")
}

tasks {
    named<ShadowJar>("shadowJar") {
        project.setProperty("mainClassName", "")
        transform(Log4j2PluginsCacheFileTransformer::class.java)
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}


