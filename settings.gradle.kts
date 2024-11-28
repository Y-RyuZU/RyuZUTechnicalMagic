rootProject.name = "RyuZUTechnicalMagic"
include(
    ":modules:api:core",
    ":modules:api:minecraft",
    ":modules:api:repositories:permanent",
    ":modules:api:repositories:temporary",
    ":modules:core:impl",
    ":modules:minecraft:paper",
    ":modules:repositories:permanent:mongo",
    ":modules:repositories:temporary:redis",
)