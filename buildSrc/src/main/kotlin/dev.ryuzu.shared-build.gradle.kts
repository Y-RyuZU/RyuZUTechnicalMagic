plugins {
    java
    application
    kotlin("jvm")
//    id("com.gradleup.shadow")
    id("com.google.devtools.ksp")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.reflections:reflections:0.10.2")

    implementation("org.joml:joml:1.10.8")

    implementation("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:dagger-compiler:2.51.1")

    implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.3"))
    implementation("io.insert-koin:koin-core:3.5.3")
    implementation("io.insert-koin:koin-annotations:2.0.0-Beta2")
    ksp("io.insert-koin:koin-ksp-compiler:2.0.0-Beta2")
}

sourceSets.named("main") {
    java.srcDir("build/generated/ksp/main/kotlin")
}

tasks.withType<Test> {
    useJUnitPlatform()
}