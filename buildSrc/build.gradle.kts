plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(kotlin("gradle-plugin"))
    implementation("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.1.0-RC2-1.0.28")
    implementation("org.jetbrains.kotlin.jvm:org.jetbrains.kotlin.jvm.gradle.plugin:2.1.0-RC2")
//    implementation("com.gradleup.shadow:shadow-gradle-plugin:8.3.5")
}