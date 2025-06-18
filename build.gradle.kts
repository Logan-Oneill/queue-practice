
plugins {
    kotlin("jvm")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    java
    id("com.avast.gradle.docker-compose") version "0.17.12"
}

group = "com.queueservice"

repositories  {
    mavenCentral()
}

dependencyManagement {
    imports {
        mavenBom(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES)
    }
}

dockerCompose {
    useComposeFiles = listOf("docker-compose.yml")
}
