plugins {
    id("dev.ryuzu.shared-build")
}

group = "dev.ryuzu"
version = "1.0.0"

repositories {
    maven {
        url = uri("https://repo.papermc.io/repository/maven-public/")
        name = "papermc"
    }
    maven {
        url = uri("https://oss.sonatype.org/content/groups/public/")
        name = "sonatype"
    }
    maven {
        url = uri("https://jitpack.io/")
        name = "jitpack"
    }
    maven {
        url = uri("https://repo.dmulloy2.net/repository/public/")
        name = "protocollib"
    }
    maven {
        url = uri("https://nexus.frengor.com/repository/public/")
        name = "fren_gor"
    }
    maven {
        url = uri("https://repo.oraxen.com/releases")
        name = "oraxen"
    }
    maven {
        url = uri("https://repo.alessiodp.com/releases/")
        name = "alessiodp-repo"
    }
    maven {
        url = uri("https://repo.codemc.io/repository/maven-public/")
        name = "code-mc"
    }
    maven {
        url = uri("https://repo.codemc.org/repository/maven-public/")
        name = "commandlib"
    }
//    maven(name = "bkcommonlib") {
//        url = uri("https://ci.mg-dev.eu/plugin/repository/everything")
//    }
    maven {
        url = uri("https://maven.enginehub.org/repo/")
        name = "worldguard"
    }
    maven {
        url = uri("https://mvn.lumine.io/repository/maven-public/")
        name = "mythic-mobs"
    }
    maven {
        url = uri("https://repo.extendedclip.com/content/repositories/placeholderapi/")
        name = "papi"
    }
    maven {
        url = uri("https://repo.jeff-media.com/public/")
        name = "spigot-update-checker"
    }
    maven {
        url = uri("https://repo.onarandombox.com/content/groups/public/")
        name = "multiverse-core"
    }
}

dependencies {
    implementation(project(":modules:api"))
    implementation(project(":modules:core"))

    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    implementation("com.charleskorn.kaml:kaml:0.61.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    implementation("com.jeff_media:SpigotUpdateChecker:3.0.3")
    implementation("com.github.stefvanschie.inventoryframework:IF:0.10.13")
    implementation("com.cjcrafter:weaponmechanics:3.3.0")

    implementation("com.github.megavexnetwork.scoreboard-library:scoreboard-library-api:2.1.3")
    runtimeOnly("com.github.megavexnetwork.scoreboard-library:scoreboard-library-implementation:2.1.3")
    implementation("com.github.megavexnetwork.scoreboard-library:scoreboard-library-extra-kotlin:2.1.3")
    runtimeOnly("com.github.megavexnetwork.scoreboard-library:scoreboard-library-modern:2.1.3")

    compileOnly("io.th0rgal:oraxen:1.170.0")
    compileOnly("me.clip:placeholderapi:2.11.5")
    compileOnly("com.comphenix.protocol:ProtocolLib:5.1.0")
    compileOnly("com.frengor:ultimateadvancementapi:2.2.8")
    compileOnly("io.lumine:Mythic-Dist:5.3.5")
    compileOnly("com.ticxo.modelengine:ModelEngine:R4.0.4")
    compileOnly("com.sk89q.worldguard:worldguard-bukkit:7.0.9")
    compileOnly("com.onarandombox.multiversecore:multiverse-core:4.3.12")
    compileOnly("dev.jorel:commandapi-bukkit-core:9.2.0")
    implementation(platform("com.intellectualsites.bom:bom-newest:1.42"))
    compileOnly("com.fastasyncworldedit:FastAsyncWorldEdit-Core")
    //    compileOnly("com.alessiodp.parties:parties-api:3.2.15")
    //    compileOnly("com.bergerkiller.bukkit:BKCommonLib:1.20.4-v1")
}

val mainClassName = "com.github.ryuzu.ryuzutechnicalmagicpaper.RyuZUTechnicalMagicPaper"

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("paper-plugin.yml") {
        expand(props)
    }
}

application {
    mainClass.set(mainClassName)
}