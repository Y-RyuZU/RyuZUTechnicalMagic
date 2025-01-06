plugins {
    id("dev.ryuzu.impl-shared-build")
}

group = "dev.ryuzu"
version = "1.0.0"


dependencies {
    implementation(project(":modules:api:configuration"))
}

