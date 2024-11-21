package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.effect.particle.particle

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo
import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredDoubleVector

/*
    TODO: Add SCULK_CHARGE, SHRIEK, and VIBRATION
    https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html
 */
@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "Type",
    defaultImpl = ConfiguredParticle::class
)
@JsonSubTypes(
    JsonSubTypes.Type(value = ConfiguredBlockParticle::class, name = "BLOCK"),
    JsonSubTypes.Type(value = ConfiguredItemParticle::class, name = "ITEM"),
    JsonSubTypes.Type(value = ConfiguredColorParticle::class, name = "COLOR"),
    JsonSubTypes.Type(value = ConfiguredTransitionColorParticle::class, name = "COLOR_TRANSITION"),
)
interface IConfiguredParticle {
    val id: String
    val count: Int
    val extra: Double
    val offset: ConfiguredDoubleVector
    val delay: Long
}