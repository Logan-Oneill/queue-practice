import org.gradle.kotlin.dsl.withType
import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    kotlin("jvm")
    id("org.springframework.boot") apply true
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    java
}

group = "com.queueservice"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":library"))
    implementation("org.springframework.boot:spring-boot-starter-web")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<BootJar>{
    enabled = true
}

tasks.withType<Test> {
    useJUnitPlatform()
}
