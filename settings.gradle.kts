plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "RyuZUTechnicalMagic"
include(
    ":modules:api:core",
    ":modules:api:configuration",
    ":modules:api:skill",
    ":modules:api:repositories:permanent",
    ":modules:api:repositories:temporary",
    ":modules:api:storage",
    ":modules:api:game",
    ":modules:api:minecraft",

    ":modules:core:impl",
    ":modules:configuration:impl",
    ":modules:skill:impl",
    ":modules:repositories:permanent:mongo",
    ":modules:repositories:temporary:redis",
    ":modules:storage:impl",
    ":modules:game:impl",
    ":modules:minecraft:paper",
)
