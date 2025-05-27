plugins {
    kotlin("jvm")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    java
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