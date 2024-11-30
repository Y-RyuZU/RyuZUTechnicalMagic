package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredColor
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredScalableColor
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/*
    TODO: Add SCULK_CHARGE, SHRIEK, and VIBRATION
    https://hub.spigotmc.org/javadocs/spigot/org/bukkit/Particle.html
 */

@Serializable
sealed interface IConfiguredParticle {
    val id: String
    val count: Int
    val extra: Double
    val offset: ConfiguredDoubleVector
    val delay: Long


    @Serializable
    @SerialName("particle")
    data class ConfiguredParticle(
        override val id: String,
        override val count: Int = 1,
        override val extra: Double = 0.0,
        override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
        override val delay: Long = 0,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle

    @Serializable
    @SerialName("block")
    data class ConfiguredBlockParticle(
        override val id: String,
        override val count: Int = 1,
        override val extra: Double = 0.0,
        override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
        override val delay: Long = 0,
        val block: String
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle

    @Serializable
    @SerialName("color")
    data class ConfiguredColorParticle(
        override val id: String,
        override val count: Int = 1,
        override val extra: Double = 0.0,
        override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
        override val delay: Long = 0,
        val color: ConfiguredColor,
        val scale: Float = 1.0f
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle

    @Serializable
    @SerialName("item")
    data class ConfiguredItemParticle(
        override val id: String,
        override val count: Int = 1,
        override val extra: Double = 0.0,
        override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
        override val delay: Long = 0,
        val item: String,
        val customModel: Int,
        val enchantmentAura: Boolean = false
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle

    @Serializable
    @SerialName("transition_color")
    data class ConfiguredTransitionColorParticle(
        override val id: String,
        override val count: Int = 1,
        override val extra: Double = 0.0,
        override val offset: ConfiguredDoubleVector = ConfiguredDoubleVector(),
        override val delay: Long = 0,
        val fromColor: ConfiguredScalableColor,
        val toColor: ConfiguredColor,
        val size: Float,
    ) : dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.particle.IConfiguredParticle
}