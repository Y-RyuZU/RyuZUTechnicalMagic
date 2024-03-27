package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerItemPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerMaterialPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.Player
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.SkillTrigger
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.service.ISkillService
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item.IItemProvider
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.hakan.basicdi.annotations.Component
import com.hakan.spinjection.listener.annotations.EventListener
import io.papermc.paper.event.entity.EntityPortalReadyEvent
import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventPriority
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Component
class BukkitEventAdapter : KoinComponent {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val itemProvider: IItemProvider by inject()
    private val skillService: ISkillService by inject()

    @EventListener
    fun onClick(bukkitEvent: PlayerInteractEvent) {
        val player = Player(bukkitEvent.player.uniqueId)

        val item: String? = if (bukkitEvent.item == null) null else itemProvider.getId(bukkitEvent.item!!)

        val event = when (bukkitEvent.action) {
            Action.RIGHT_CLICK_AIR -> PlayerRightClickAirEvent(
                player, item
            )
            Action.LEFT_CLICK_AIR -> PlayerLeftClickAirEvent(
                player, item
            )
            Action.RIGHT_CLICK_BLOCK -> PlayerRightClickBlockEvent(
                player, item,
                bukkitEvent.clickedBlock!!.location.toIntConfigured(),
                bukkitEvent.clickedBlock!!.type.name
            )
            Action.LEFT_CLICK_BLOCK -> PlayerLeftClickBlockEvent(
                player, item,
                bukkitEvent.clickedBlock!!.location.toIntConfigured(),
                bukkitEvent.clickedBlock!!.type.name
            )
            else -> return
        }
        eventListenerCollector.publish(event)
    }

    @EventListener(priority = EventPriority.HIGH)
    fun onDamage(bukkitEvent: org.bukkit.event.entity.EntityDamageEvent) {
        val entity = bukkitEvent.entity
        if (entity !is LivingEntity) return
        var event: IEntityDamageEvent = EntityDamageEvent(
            entity.uniqueId,
            bukkitEvent.damage
        )
        if (entity is org.bukkit.entity.Player) event = PlayerDamageEvent(
            event,
            Player(entity.uniqueId)
        )
        if (bukkitEvent.damage > entity.health) event = EntityDeathEvent(event)
        if (event is PlayerDamageEvent && bukkitEvent.damage > entity.health)
            event = PlayerDeathEvent(event)

        eventListenerCollector.publish(event)
    }

    @EventHandler
    fun onQuit(bukkitEvent: org.bukkit.event.player.PlayerQuitEvent) {
        val event = PlayerQuitEvent(Player(bukkitEvent.player.uniqueId))
        eventListenerCollector.publish(event)
    }


    @EventHandler
    fun onPickup(bukkitEvent: EntityPickupItemEvent) {
        if (bukkitEvent.entity !is org.bukkit.entity.Player) return
        val player = Player(bukkitEvent.entity.uniqueId)
        val bukkitItem = bukkitEvent.item.itemStack
        val id = itemProvider.getId(bukkitItem)
        if (id == null) {
            val event = PlayerMaterialPickUpEvent(player, bukkitItem.type.name, bukkitEvent.item.uniqueId)
            eventListenerCollector.publish(event)
            bukkitEvent.isCancelled = event.isCancelled
            bukkitEvent.item.itemStack.type = Material.valueOf(event.material)
        } else {
            val event = PlayerItemPickUpEvent(player, id, bukkitEvent.item.uniqueId)
            eventListenerCollector.publish(event)
            bukkitEvent.isCancelled = event.isCancelled
            bukkitEvent.item.itemStack = itemProvider.getItemStack(event.item)
        }
    }

    @EventHandler
    fun onPortalReady(bukkitEvent: EntityPortalReadyEvent) {
        if (bukkitEvent.entity !is org.bukkit.entity.Player) return
        val event = PlayerPortalReadyEvent(Player(bukkitEvent.entity.uniqueId))
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }
}