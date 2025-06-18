import com.bmuschko.gradle.docker.tasks.container.DockerCreateContainer
import com.bmuschko.gradle.docker.tasks.container.DockerStartContainer
import com.bmuschko.gradle.docker.tasks.image.DockerBuildImage

plugins {
    kotlin("jvm")
    id("org.springframework.boot") apply false
    id("io.spring.dependency-management")
    kotlin("plugin.spring")
    java
//    plugin dsl
//        id("com.bmuschko.docker-remote-api") version "9.4.0"
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

// support for running docker files with gradle tasks
// following https://bmuschko.github.io/gradle-docker-plugin/current/user-guide/
buildscript {
    repositories {
        gradlePluginPortal()
    }
    dependencies {
        classpath("com.bmuschko:gradle-docker-plugin:9.4.0")
    }
}

apply(plugin = "com.bmuschko.docker-remote-api")

// Use task types
//tasks.create("buildRabbitMqContainer", DockerBuildImage::class) {
//    inputDir.set(file("Dockerfile"))
//    images.add("rabbitMqLocal:latest")
//}

val buildRabbitMqContainer by tasks.creating(DockerBuildImage::class) {
    inputDir.set(file("Dockerfile"))
    images.add("test/myapp:latest")
}

val createMyAppContainer by tasks.creating(DockerCreateContainer::class) {
    dependsOn(buildRabbitMqContainer)
    targetImageId(buildRabbitMqContainer.getImageId())
    hostConfig.portBindings.set(listOf("8080:8080"))
    hostConfig.autoRemove.set(true)
}

val startMyAppContainer by tasks.creating(DockerStartContainer::class) {
    dependsOn(createMyAppContainer)
    targetContainerId(createMyAppContainer.getContainerId())
}

val stopMyAppContainer by tasks.creating(DockerStopContainer::class) {
    targetContainerId(createMyAppContainer.getContainerId())
}

tasks.create("functionalTestMyApp", Test::class) {
    dependsOn(startMyAppContainer)
    finalizedBy(stopMyAppContainer)
}

