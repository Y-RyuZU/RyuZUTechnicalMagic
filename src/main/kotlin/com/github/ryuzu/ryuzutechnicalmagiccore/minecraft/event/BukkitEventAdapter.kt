package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockBreakEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.block.PlayerBlockPlaceEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerLeftClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickAirEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.click.PlayerRightClickBlockEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.damage.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerItemPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerMaterialPickUpEvent
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
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Component
class BukkitEventAdapter : Listener, KoinComponent {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val itemProvider: IItemProvider by inject()
    private val skillService: ISkillService by inject()

    @EventListener(priority = EventPriority.HIGH)
    fun onClick(bukkitEvent: PlayerInteractEvent) {
        val player = Player(bukkitEvent.player.uniqueId)
        val item: String? = if (bukkitEvent.item == null) null else itemProvider.getId(bukkitEvent.item!!)
        val offHand = bukkitEvent.hand?.equals(EquipmentSlot.OFF_HAND) ?: false

        val event = when (bukkitEvent.action) {
            Action.RIGHT_CLICK_AIR -> PlayerRightClickAirEvent(
                player, item, offHand
            )

            Action.LEFT_CLICK_AIR -> PlayerLeftClickAirEvent(
                player, item, offHand
            )

            Action.RIGHT_CLICK_BLOCK -> PlayerRightClickBlockEvent(
                player, item, offHand,
                bukkitEvent.clickedBlock!!.location.toIntConfigured(),
                bukkitEvent.clickedBlock!!.type.name
            )

            Action.LEFT_CLICK_BLOCK -> PlayerLeftClickBlockEvent(
                player, item, offHand,
                bukkitEvent.clickedBlock!!.location.toIntConfigured(),
                bukkitEvent.clickedBlock!!.type.name
            )

            else -> return
        }
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onDamage(bukkitEvent: org.bukkit.event.entity.EntityDamageEvent) {
        println("onDamageHigh ${bukkitEvent.isCancelled}")
        if (bukkitEvent.isCancelled) return
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
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onDeath(bukkitEvent: org.bukkit.event.entity.EntityDamageEvent) {
        println("onDamageHighest ${bukkitEvent.isCancelled}")
        if (bukkitEvent.isCancelled) return
        val entity = bukkitEvent.entity
        if (entity !is LivingEntity) return
        println("onDeath ${bukkitEvent.damage} ${entity.health}")
        if (bukkitEvent.damage < entity.health) return
        var event: IEntityDeathEvent = EntityDeathEvent(
            entity.uniqueId,
            bukkitEvent.damage
        )
        if (bukkitEvent.entity is org.bukkit.entity.Player)
            event = PlayerDeathEvent(
                event,
                Player(entity.uniqueId)
            )
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = true
        entity.health = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
    }

    @EventListener(priority = EventPriority.HIGH)
    fun onQuit(bukkitEvent: org.bukkit.event.player.PlayerQuitEvent) {
        val event = PlayerQuitEvent(Player(bukkitEvent.player.uniqueId))
        eventListenerCollector.publish(event)
    }

    @EventListener(priority = EventPriority.HIGH)
    fun onBreak(bukkitEvent: org.bukkit.event.block.BlockBreakEvent) {
        if (bukkitEvent.isCancelled) return
        val event = PlayerBlockBreakEvent(
            Player(bukkitEvent.player.uniqueId),
            bukkitEvent.block.location.toIntConfigured(),
            bukkitEvent.block.type.name
        )
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventListener(priority = EventPriority.HIGH)
    fun onPlace(bukkitEvent: org.bukkit.event.block.BlockPlaceEvent) {
        if (bukkitEvent.isCancelled) return
        val event = PlayerBlockPlaceEvent(
            Player(bukkitEvent.player.uniqueId),
            bukkitEvent.block.location.toIntConfigured(),
            bukkitEvent.block.type.name
        )
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventListener(priority = EventPriority.HIGH)
    fun onPickup(bukkitEvent: EntityPickupItemEvent) {
        if (bukkitEvent.isCancelled) return
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

    @EventListener(priority = EventPriority.HIGH)
    fun onPortalReady(bukkitEvent: EntityPortalReadyEvent) {
        if (bukkitEvent.entity !is org.bukkit.entity.Player) return
        val event = PlayerPortalReadyEvent(Player(bukkitEvent.entity.uniqueId))
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }
}