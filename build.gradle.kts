plugins {
    kotlin("jvm") version "2.1.0"
    application
}

group = "ru.svyat.train"
version = "0.0.1"

repositories {
    mavenLocal()
    mavenCentral()
}

tasks.test {
    useJUnitPlatform()
}

dependencies {
    testImplementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.18.2")
    testImplementation(kotlin("test"))
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.1.0")
}

application {
    mainClass.set("MainKt")
}