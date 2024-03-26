package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.util.wrapper.particle

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.particle.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.particle.AbstractParticleService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ItemUtility
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.PlayerUtility.Companion.toPlayer
import org.bukkit.*
import org.bukkit.entity.Player
import org.bukkit.util.Vector
import org.koin.core.annotation.Single
import org.koin.core.component.inject

@Single
class ParticleServiceImpl : AbstractParticleService() {
    private val itemUtility: ItemUtility by inject()

    override fun spawnParticle(
        particle: IConfiguredParticle,
        configuredLocation: ConfiguredDoubleLocation,
        vector: ConfiguredDoubleVector,
        receivers: Set<IPlayer>
    ) {
        val location = configuredLocation.toLocation()
        val builder = Particle.valueOf(particle.id).builder()
            .count(particle.count)
            .extra(particle.extra)
            .location(location)
            .offset(particle.offset.x * vector.x, particle.offset.y * vector.y, particle.offset.z * vector.z)
            .receivers(receivers.map { it.toPlayer() })

        when (particle) {
            is ConfiguredParticle -> builder.spawn()
            is ConfiguredColorParticle -> builder.color(Color.fromRGB(particle.color.color.r, particle.color.color.g, particle.color.color.b), particle.color.size).spawn()
            is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particle.block.uppercase())).spawn()
            is ConfiguredItemParticle -> builder.data(itemUtility.createItemStack(Material.valueOf(particle.item), particle.customModel, particle.enchantmentAura)).spawn()
            is ConfiguredTransitionColorParticle -> builder.data(Particle.DustTransition(Color.fromRGB(particle.fromColor.color.r, particle.fromColor.color.g, particle.fromColor.color.b), Color.fromRGB(particle.toColor.r, particle.toColor.g, particle.toColor.b), particle.fromColor.size))
        }
    }

    override fun spawnParticle(particle: IConfiguredParticle, vertical: Boolean, receivers: Set<IPlayer>) {
        val verticalVector = Vector(0.0, 1.0, 0.0)
        val locations: Map<Player, Location> = receivers.associate {
            it.toPlayer() to (it.toPlayer().location.apply {
                if (vertical) setDirection(verticalVector)
            })
        }
        val builder = Particle.valueOf(particle.id).builder()
            .count(particle.count)
            .extra(particle.extra)

        locations.entries.forEach { (player, location) ->
            val vector = location.direction
            builder
                .location(location)
                .offset(particle.offset.x * vector.x, particle.offset.y * vector.y, particle.offset.z * vector.z)
                .receivers(setOf(player))

            when (particle) {
                is ConfiguredParticle -> builder.spawn()
                is ConfiguredColorParticle -> builder.color(Color.fromRGB(particle.color.color.r, particle.color.color.g, particle.color.color.b), particle.color.size).spawn()
                is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particle.block.uppercase())).spawn()
                is ConfiguredItemParticle -> builder.data(itemUtility.createItemStack(Material.valueOf(particle.item), particle.customModel, particle.enchantmentAura)).spawn()
                is ConfiguredTransitionColorParticle -> builder.data(Particle.DustTransition(Color.fromRGB(particle.fromColor.color.r, particle.fromColor.color.g, particle.fromColor.color.b), Color.fromRGB(particle.toColor.r, particle.toColor.g, particle.toColor.b), particle.fromColor.size))
            }
        }
    }

    override fun spawnParticle(particle: IConfiguredParticle, location: ConfiguredDoubleLocation) {
        val loc = location.toLocation()
        val builder = Particle.valueOf(particle.id).builder()
            .count(particle.count)
            .extra(particle.extra)
            .location(loc)
            .offset(particle.offset.x, particle.offset.y, particle.offset.z)

        when (particle) {
            is ConfiguredParticle -> builder.spawn()
            is ConfiguredColorParticle -> builder.color(Color.fromRGB(particle.color.color.r, particle.color.color.g, particle.color.color.b), particle.color.size).spawn()
            is ConfiguredBlockParticle -> builder.data(Bukkit.createBlockData(particle.block.uppercase())).spawn()
            is ConfiguredItemParticle -> builder.data(itemUtility.createItemStack(Material.valueOf(particle.item), particle.customModel, particle.enchantmentAura)).spawn()
            is ConfiguredTransitionColorParticle -> builder.data(Particle.DustTransition(Color.fromRGB(particle.fromColor.color.r, particle.fromColor.color.g, particle.fromColor.color.b), Color.fromRGB(particle.toColor.r, particle.toColor.g, particle.toColor.b), particle.fromColor.size))
        }
    }
}