package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.event

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.*
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EntityDeathEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.Player
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item.IItemProvider
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toIntConfigured
import com.hakan.basicdi.annotations.Component
import com.hakan.spinjection.listener.annotations.EventListener
import io.papermc.paper.event.entity.EntityPortalReadyEvent
import org.bukkit.Material
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventPriority
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerAttemptPickupItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Component
class BukkitEventAdapter : KoinComponent {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val itemProvider: IItemProvider by inject()

    @EventListener
    fun onRightClickBlock(bukkitEvent: PlayerInteractEvent) {
        if(bukkitEvent.action != org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) return
        val event = PlayerRightClickBlockEvent(
            Player(bukkitEvent.player.uniqueId),
            bukkitEvent.clickedBlock!!.location.toIntConfigured()
        )
        eventListenerCollector.publish(event)
    }

    @EventListener(ignoreCancelled = true, priority = EventPriority.HIGH)
    fun onDeath(bukkitEvent: EntityDamageEvent) {
        if(bukkitEvent.entity !is org.bukkit.entity.Player) return
        if (bukkitEvent.damage < (bukkitEvent.entity as LivingEntity).health) return
        val event = EntityDeathEvent(Player(bukkitEvent.entity.uniqueId)).apply { lastDamage = bukkitEvent.damage}
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = true
    }

    @EventHandler
    fun onQuit(bukkitEvent: org.bukkit.event.player.PlayerQuitEvent) {
        val event = PlayerQuitEvent(Player(bukkitEvent.player.uniqueId))
        eventListenerCollector.publish(event)
    }


    @EventHandler
    fun onPickup(bukkitEvent: EntityPickupItemEvent) {
        if(bukkitEvent.entity !is org.bukkit.entity.Player) return
        val player = Player(bukkitEvent.entity.uniqueId)
        val bukkitItem = bukkitEvent.item.itemStack
        val id = itemProvider.getId(bukkitItem)
        if(id == null) {
            val event = PlayerMaterialPickUpEvent(player, bukkitItem.type.name, bukkitEvent.item.uniqueId)
            eventListenerCollector.publish(event)
            bukkitEvent.isCancelled = event.isCancelled
            bukkitEvent.item.itemStack.type = Material.valueOf(event.material)
        }
        else {
            val event = PlayerItemPickUpEvent(player, id, bukkitEvent.item.uniqueId)
            eventListenerCollector.publish(event)
            bukkitEvent.isCancelled = event.isCancelled
            bukkitEvent.item.itemStack = itemProvider.getItemStack(event.item)
        }
    }

    @EventHandler
    fun onPortalReady(bukkitEvent: EntityPortalReadyEvent) {
        if(bukkitEvent.entity !is org.bukkit.entity.Player) return
        val event = PlayerPortalReadyEvent(Player(bukkitEvent.entity.uniqueId))
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }
}