/*
 * This file was generated by the Gradle 'init' task.
 */
plugins {
    `java-library`
    `maven-publish`
    id("org.springframework.boot") version "3.2.9"
    id("io.spring.dependency-management") version "1.1.0"
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api(libs.org.springframework.boot.spring.boot.starter.web)
    api(libs.org.springframework.boot.spring.boot.starter.data.rest)
    testImplementation(libs.org.springframework.boot.spring.boot.starter.test)
}

group = "com.example"
version = "1"
description = "simple_rest"
java.sourceCompatibility = JavaVersion.VERSION_17
java.targetCompatibility = JavaVersion.VERSION_17


publishing {
    publications.create<MavenPublication>("maven") {
        from(components["java"])
    }
}

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
