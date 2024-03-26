package com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.PlayerItemPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general.ConfiguredGeneralParameter
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.AbstractGeneratorService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.StarStockData
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.model.item.IItemProvider
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.util.ConfiguredUtility.Companion.toVector
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack
import org.koin.core.component.inject
import java.util.UUID
import kotlin.random.Random

class GeneratorServiceImpl(gameService: IGameService) : AbstractGeneratorService(gameService), IEventHandler {
    private val itemProvider: IItemProvider by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()

    private val parameter: ConfiguredGeneralParameter by inject()

    override fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double): StarStockData {
        val starStockData = StarStockData()
        val location = location.toLocation()
        val littleStarAmount = amount % 10
        val bigStarAmount = amount / 10

        fun generateStar(starAmount: Int, starItem: String, starList: MutableSet<UUID>) {
            for (i in 0 until starAmount) {
                val item = itemProvider.getItemStack(starItem)
                item.lore(listOf(Component.text(UUID.randomUUID().toString())))
                val droppedItem = spawnItem(location, item)
                if(scatter != 0.0) droppedItem.velocity = ConfiguredDoubleVector.random().toVector().multiply(scatter)
                starList.add(droppedItem.uniqueId)
            }
        }

        generateStar(littleStarAmount, parameter.generatorParameter.littleStarItem, starStockData.littleStars)
        generateStar(bigStarAmount, parameter.generatorParameter.bigStarItem, starStockData.bigStars)

        return starStockData
    }

    init {
        eventListenerCollector.unregisterEventListener(this)
    }

    override fun stop() {
        super.stop()
        eventListenerCollector.registerEventListener(this)
    }

    @EventHandler
    fun onPickup(event: PlayerItemPickUpEvent) {
        onPickup(event.itemEntity)
    }

    override fun generateItem(location: ConfiguredDoubleLocation, rarity: Int) : UUID {
        val items = parameter.generatorParameter.itemTable[rarity]!!
        val item = itemProvider.getItemStack(items.elementAt(Random.nextInt(items.size)))
        return spawnItem(location.toLocation(), item).uniqueId
    }

    override fun generateHyper(location: ConfiguredDoubleLocation) {
        val item = itemProvider.getItemStack(parameter.generatorParameter.hyperItem)
        spawnItem(location.toLocation(), item)
    }

    private fun spawnItem(location: Location, item: ItemStack): Item {
        val droppedItem = location.world.spawnEntity(location, EntityType.DROPPED_ITEM) as Item
        droppedItem.itemStack = item
        return droppedItem
    }
}