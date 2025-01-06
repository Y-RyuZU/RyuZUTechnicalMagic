package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.event

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.PlayerPortalReadyEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.PlayerQuitEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.block.PlayerBlockBreakEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.block.PlayerBlockPlaceEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerLeftClickAirEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerLeftClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerRightClickAirEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.click.PlayerRightClickBlockEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.damage.*
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item.PlayerDropEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item.PlayerPickUpEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.event.publisher.IEventListenerCollector
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntityManager
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.storage.Item
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.item.IItemAdapter
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.adapter.item.ItemAdapterImpl
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.damage.RTMDamageSource
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toIntConfigured
import io.papermc.paper.event.entity.EntityPortalReadyEvent
import org.bukkit.attribute.Attribute
import org.bukkit.entity.LivingEntity
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.event.entity.EntityPickupItemEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class BukkitEventAdapter : Listener, KoinComponent {
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val entityManager: IEntityManager by inject()
    private val itemAdapter: ItemAdapterImpl by inject()

    @EventHandler(priority = EventPriority.HIGH)
    fun onClick(bukkitEvent: PlayerInteractEvent) {
        val player = entityManager.getPlayer(bukkitEvent.player.uniqueId)
        val item: Item? = bukkitEvent.item?.let { itemAdapter.getItem(it) }
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

        println(event)
        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onDamage(bukkitEvent: org.bukkit.event.entity.EntityDamageEvent) {
        if (bukkitEvent.isCancelled) return
        val entity = bukkitEvent.entity
        if (entity !is LivingEntity) return

        var event: IEntityDamageEvent = EntityDamageEvent(
            entityManager.getLivingEntity(entity.uniqueId),
            bukkitEvent.damage
        )

        val source = bukkitEvent.damageSource
        if (source is RTMDamageSource) {
            event = EntitySkillDamageEvent(
                event,
                source.skillSetId,
                source.skillId
            )
        }

        if (bukkitEvent is org.bukkit.event.entity.EntityDamageByEntityEvent) {
            val damager = bukkitEvent.damager
            if (damager is LivingEntity) {
                event = EntityDamageByEntityEvent(
                    event,
                    entityManager.getLivingEntity(damager.uniqueId)
                )

                if (source is RTMDamageSource) {
                    event = EntitySkillDamageByEntityEvent(
                        event,
                        source.skillSetId,
                        source.skillId
                    )
                }
            }
        }

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    fun onDeath(bukkitEvent: org.bukkit.event.entity.EntityDamageEvent) {
        if (bukkitEvent.isCancelled) return
        val entity = bukkitEvent.entity
        if (entity !is LivingEntity) return
        if (bukkitEvent.damage < entity.health) return

        var event: IEntityDeathEvent = EntityDeathEvent(
            entityManager.getLivingEntity(entity.uniqueId),
            bukkitEvent.damage
        )

        val source = bukkitEvent.damageSource
        if (source is RTMDamageSource) {
            event = EntitySkillDeathEvent(
                event,
                source.skillSetId,
                source.skillId
            )
        }

        if (bukkitEvent is org.bukkit.event.entity.EntityDamageByEntityEvent) {
            val damager = bukkitEvent.damager
            if (damager is LivingEntity) {
                event = EntityDeathByEntityEvent(
                    event,
                    entityManager.getLivingEntity(damager.uniqueId)
                )

                if (source is RTMDamageSource) {
                    event = EntitySkillDeathByEntityEvent(
                        event,
                        source.skillSetId,
                        source.skillId
                    )
                }
            }
        }

        eventListenerCollector.publish(event)
        if(entity is org.bukkit.entity.Player) {
            bukkitEvent.isCancelled = true
            entity.health = entity.getAttribute(Attribute.GENERIC_MAX_HEALTH)!!.value
        }
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onQuit(bukkitEvent: org.bukkit.event.player.PlayerQuitEvent) {
        val event = PlayerQuitEvent(
            entityManager.getPlayer(bukkitEvent.player.uniqueId)
        )

        eventListenerCollector.publish(event)
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onBreak(bukkitEvent: BlockBreakEvent) {
        if (bukkitEvent.isCancelled) return

        val event = PlayerBlockBreakEvent(
            entityManager.getPlayer(bukkitEvent.player.uniqueId),
            bukkitEvent.block.location.toIntConfigured(),
            bukkitEvent.block.type.name
        )

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onPlace(bukkitEvent: BlockPlaceEvent) {
        if (bukkitEvent.isCancelled) return

        val event = PlayerBlockPlaceEvent(
            entityManager.getPlayer(bukkitEvent.player.uniqueId),
            bukkitEvent.block.location.toIntConfigured(),
            bukkitEvent.block.type.name
        )

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onPickup(bukkitEvent: EntityPickupItemEvent) {
        if (bukkitEvent.isCancelled) return
        if (bukkitEvent.entity !is org.bukkit.entity.Player) return

        val event = PlayerPickUpEvent(
            entityManager.getPlayer(bukkitEvent.entity.uniqueId),
            itemAdapter.getItem(bukkitEvent.item.itemStack),
            entityManager.getEntity(bukkitEvent.entity.uniqueId)
        )

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
        bukkitEvent.item.itemStack = itemAdapter.getItemStack(event.item)
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onDrop(bukkitEvent: org.bukkit.event.player.PlayerDropItemEvent) {
        if (bukkitEvent.isCancelled) return

        val event = PlayerDropEvent(
            entityManager.getPlayer(bukkitEvent.player.uniqueId),
            itemAdapter.getItem(bukkitEvent.itemDrop.itemStack)
        )

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
        bukkitEvent.itemDrop.itemStack = itemAdapter.getItemStack(event.item)
    }

    @EventHandler(priority = EventPriority.HIGH)
    fun onPortalReady(bukkitEvent: EntityPortalReadyEvent) {
        if (bukkitEvent.entity !is org.bukkit.entity.Player) return

        val event = PlayerPortalReadyEvent(
            entityManager.getPlayer(bukkitEvent.entity.uniqueId)
        )

        eventListenerCollector.publish(event)
        bukkitEvent.isCancelled = event.isCancelled
    }
}