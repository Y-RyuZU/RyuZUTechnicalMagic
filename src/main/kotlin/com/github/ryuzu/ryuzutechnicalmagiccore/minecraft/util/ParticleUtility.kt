package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util

import com.destroystokyo.paper.ParticleBuilder
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.particle.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSound
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.sound.ConfiguredSoundSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.TaskUnit
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.*
import org.bukkit.block.BlockState
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.util.*

@Single
class ParticleUtility : KoinComponent {
    private val itemUtility: ItemUtility by inject()

    fun convertTaskUnits(particleSet: ConfiguredParticleSet, location: Location): List<TaskUnit> {
        return particleSet.particles.map { particle ->
            TaskUnit(particle.delay) { _, _ ->
                spawnParticle(particle, location)
            }
        }
    }

    fun spawnParticle(particles: IConfiguredParticle, location: Location) {
        val builder = Particle.valueOf(particles.id).builder()
            .count(particles.count)
            .extra(particles.extra)
            .location(location)
            .apply {
                if (particles.extra == 0.0)
                    offset(particles.offset.x, particles.offset.y, particles.offset.z)
                else
                    offset(location.direction.x, location.direction.y, location.direction.z)
            }

        when (particles) {
            is ConfiguredParticle -> builder.spawn()
            is ConfiguredColorParticle -> builder.color(Color.fromRGB(particles.color.color.r, particles.color.color.g, particles.color.color.b), particles.color.size).spawn()
            is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particles.block.uppercase())).spawn()
            is ConfiguredItemParticle -> builder.data(itemUtility.createItemStack(Material.valueOf(particles.item), particles.customModel, particles.enchantmentAura)).spawn()
            is ConfiguredTransitionColorParticle -> builder.data(Particle.DustTransition(Color.fromRGB(particles.fromColor.color.r, particles.fromColor.color.g, particles.fromColor.color.b), Color.fromRGB(particles.toColor.r, particles.toColor.g, particles.toColor.b), particles.fromColor.size))
        }
    }
}