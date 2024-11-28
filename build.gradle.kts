plugins {
    id("dev.ryuzu.shared-build")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.4.20"
}

group = "dev.ryuzu"
version = "1.0.0"

dependencies {
    implementation(project(":modules:api:core"))

    implementation("com.charleskorn.kaml:kaml:0.61.0")

}