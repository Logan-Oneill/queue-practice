rootProject.name = "queue-service"
include("messageReader", "messageSender", "library")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.9.25"
        id("org.jetbrains.kotlin.plugin.spring") version "1.9.25"
        id("org.springframework.boot") version "3.5.0"
        id("io.spring.dependency-management") version "1.1.7"
    }
}


//from spring initializer
//plugins {
//    kotlin("jvm") version "1.9.25"
//    kotlin("plugin.spring") version "1.9.25"
//    id("org.springframework.boot") version "3.5.0"
//    id("io.spring.dependency-management") version "1.1.7"
//}
//
//group = "com.logan"
//version = "0.0.1-SNAPSHOT"
//
//java {
//    toolchain {
//        languageVersion = JavaLanguageVersion.of(21)
//    }
//}