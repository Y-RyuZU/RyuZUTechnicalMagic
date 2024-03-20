package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.particle.AbstractParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ItemUtility
import org.bukkit.*
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.*

@Single
class ParticleServiceImpl : AbstractParticleService() {
    private val itemUtility: ItemUtility by inject()

    fun convertTaskUnits(particleSet: ConfiguredParticleSet, location: ConfiguredDoubleLocation): List<TaskUnit> {
        return particleSet.particles.map { particle ->
            TaskUnit(particle.delay) { _, _ ->
                spawnParticle(particle, location)
            }
        }
    }

    override fun spawnParticle(particle: IConfiguredParticle, configuredLocation: ConfiguredDoubleLocation) {
        val location = configuredLocation.toLocation()
        val builder = Particle.valueOf(particle.id).builder()
            .count(particle.count)
            .extra(particle.extra)
            .location(location)
            .apply {
                if (particle.extra == 0.0)
                    offset(particle.offset.x, particle.offset.y, particle.offset.z)
                else
                    offset(location.direction.x, location.direction.y, location.direction.z)
            }

        when (particle) {
            is ConfiguredParticle -> builder.spawn()
            is ConfiguredColorParticle -> builder.color(Color.fromRGB(particle.color.color.r, particle.color.color.g, particle.color.color.b), particle.color.size).spawn()
            is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particle.block.uppercase())).spawn()
            is ConfiguredItemParticle -> builder.data(itemUtility.createItemStack(Material.valueOf(particle.item), particle.customModel, particle.enchantmentAura)).spawn()
            is ConfiguredTransitionColorParticle -> builder.data(Particle.DustTransition(Color.fromRGB(particle.fromColor.color.r, particle.fromColor.color.g, particle.fromColor.color.b), Color.fromRGB(particle.toColor.r, particle.toColor.g, particle.toColor.b), particle.fromColor.size))
        }
    }
}