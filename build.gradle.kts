plugins {
    kotlin("jvm") version "1.8.0"
    application
    id("org.openjfx.javafxplugin") version "0.0.13"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}
application {
    mainClass.set("com.example.demo.app.MyApp")
}
javafx {
    version = "11.0.2"
    modules = mutableListOf("javafx.controls","javafx.graphics","javafx.fxml")
}
dependencies {
    testImplementation(kotlin("test"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("no.tornado:tornadofx:1.7.20")
    implementation("net.objecthunter:exp4j:0.4.8")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}