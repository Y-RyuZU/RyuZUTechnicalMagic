plugins {
    id("dev.ryuzu.impl-shared-build")
}

group = "dev.ryuzu"
version = "1.0.0"

dependencies {
    implementation(project(":modules:api:core"))
    implementation(project(":modules:api:minecraft"))
    implementation(project(":modules:api:skill"))
}