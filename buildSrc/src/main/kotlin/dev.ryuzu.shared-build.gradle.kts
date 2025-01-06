plugins {
    java
    application
    kotlin("jvm")
//    id("com.gradleup.shadow")
    id("org.jetbrains.kotlin.plugin.serialization")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.reflections:reflections:0.10.2")

    implementation("org.joml:joml:1.10.8")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
}

sourceSets.named("main") {
    java.srcDir("build/generated/ksp/main/kotlin")
}

tasks.withType<Test> {
    useJUnitPlatform()
}