import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    java
    kotlin("jvm")
    kotlin("plugin.spring")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
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
