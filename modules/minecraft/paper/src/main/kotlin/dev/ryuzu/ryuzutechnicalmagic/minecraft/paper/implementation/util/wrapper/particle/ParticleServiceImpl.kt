package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.particle.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.AbstractParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.IParticleService
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ItemUtility
import org.bukkit.*
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single([IParticleService::class])
class ParticleServiceImpl : AbstractParticleService() {
    private val itemUtility: ItemUtility by inject()

    override fun spawnParticle(
        particle: IConfiguredParticle,
        location: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector
    ) {
        val loc = location.toLocation()
        val builder = Particle.valueOf(particle.id.uppercase()).builder()
            .count(particle.count)
            .extra(particle.extra)
            .location(loc)
            .apply {
                if (particle.count == 0)
                    offset(vector.x(), vector.y(), vector.z())
                else
                    offset(particle.offset.x(), particle.offset.y(), particle.offset.z())
            }

        when (particle) {
            is ConfiguredParticle -> builder.spawn()
            is ConfiguredColorParticle -> builder.color(
                Color.fromRGB(
                    particle.color.r,
                    particle.color.g,
                    particle.color.b
                ), particle.scale
            ).spawn()

            is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particle.block.uppercase())).spawn()
            is ConfiguredItemParticle -> builder.data(
                itemUtility.createItemStack(
                    Material.valueOf(particle.item.uppercase()),
                    particle.customModel,
                    particle.enchantmentAura
                )
            ).spawn()

            is ConfiguredTransitionColorParticle -> builder.data(
                Particle.DustTransition(
                    Color.fromRGB(
                        particle.fromColor.color.r,
                        particle.fromColor.color.g,
                        particle.fromColor.color.b
                    ),
                    Color.fromRGB(particle.toColor.r, particle.toColor.g, particle.toColor.b),
                    particle.fromColor.size
                )
            )
        }
    }
}