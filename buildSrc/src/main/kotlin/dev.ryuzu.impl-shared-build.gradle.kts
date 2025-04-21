import gradle.kotlin.dsl.accessors._09a53d400d2b5de2bc82b7348e6132fd.sourceSets

plugins {
    id("dev.ryuzu.shared-build")
    id("com.google.devtools.ksp")
}

dependencies {
    implementation("com.google.dagger:dagger-compiler:2.51.1")
    ksp("com.google.dagger:dagger-compiler:2.51.1")

    implementation(project.dependencies.platform("io.insert-koin:koin-bom:3.5.3"))
    implementation("io.insert-koin:koin-core:3.5.3")
    implementation("io.insert-koin:koin-annotations:2.0.0-Beta2")
    ksp("io.insert-koin:koin-ksp-compiler:2.0.0-Beta2")

    implementation("com.charleskorn.kaml:kaml:0.61.0")
}

tasks.named<Jar>("jar") {
    dependsOn(tasks.named("compileKotlin"))
}

tasks.named("compileKotlin") {
    dependsOn("kspKotlin")
}

sourceSets.named("main") {
    java.srcDir("build/generated/ksp/main/kotlin")
}

//sourceSets.named("main") {
//    java.srcDir("build/generated/ksp/main/kotlin")
//}