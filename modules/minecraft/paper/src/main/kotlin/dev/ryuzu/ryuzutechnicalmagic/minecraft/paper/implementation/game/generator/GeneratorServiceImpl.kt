package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.data.item.PlayerPickUpEvent
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.EventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.handler.IEventHandler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.event.publisher.IEventListenerCollector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage.ConfiguredStage
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.AbstractGeneratorService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.IGeneratorService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator.StarStockData
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntityManager
import dev.ryuzu.ryuzutechnicalmagic.core.api.model.item.IItemManager
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toLocation
import dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.util.ConfiguredUtility.Companion.toVector
import net.kyori.adventure.text.Component
import org.bukkit.Location
import org.bukkit.entity.EntityType
import org.bukkit.entity.Item
import org.bukkit.inventory.ItemStack
import org.koin.core.annotation.InjectedParam
import org.koin.core.annotation.Single
import org.koin.core.component.inject
import java.util.UUID
import kotlin.random.Random

@Single([IGeneratorService::class])
class GeneratorServiceImpl(
    @InjectedParam gameService: IGameService,
    @InjectedParam stage: ConfiguredStage
) : AbstractGeneratorService(gameService, stage), IEventHandler {
    private val itemManager: IItemManager by inject()
    private val eventListenerCollector: IEventListenerCollector by inject()
    private val entityManager: IEntityManager by inject()

    override fun generateStar(location: ConfiguredDoubleLocation, amount: Int, scatter: Double): StarStockData {
        val starStockData = StarStockData()
        val location = location.toLocation()
        val littleStarAmount = amount % 10
        val bigStarAmount = amount / 10

        fun generateStar(starAmount: Int, starItem: String, starList: MutableSet<IEntity>) {
            for (i in 0 until starAmount) {
                val item = itemManager.getItemStack(starItem)
                item.lore(listOf(Component.text(UUID.randomUUID().toString())))
                val droppedItem = spawnItem(location, item)
                if (scatter != 0.0) droppedItem.velocity = ConfiguredDoubleVector.random().toVector().multiply(scatter)
                starList.add(entityManager.getEntity(droppedItem.uniqueId))
            }
        }

        generateStar(littleStarAmount, parameter.generatorParameter.littleStarItem, starStockData.littleStars)
        generateStar(bigStarAmount, parameter.generatorParameter.bigStarItem, starStockData.bigStars)

        return starStockData
    }

    init {
        eventListenerCollector.registerEventListener(this)
    }

    override fun stop() {
        super.stop()
        eventListenerCollector.unregisterEventListener(this)
    }

    @EventHandler(priority = 50)
    override fun onPickup(event: PlayerPickUpEvent) {
        if (!gameService.isGamePlayer(event.player)) return
        val generatorItems = listOf(
            parameter.generatorParameter.littleStarItem,
            parameter.generatorParameter.bigStarItem,
            parameter.generatorParameter.hyperItem,
            stage.itemTable.values.flatten()
        )
        if (!generatorItems.contains(event.item)) return
        super.onPickup(event)
    }

    override fun generateItem(location: ConfiguredDoubleLocation, rarity: Int): IEntity {
        val items = stage.itemTable[rarity]!!
        val item = itemManager.getItemStack(items.elementAt(Random.nextInt(items.size)))
        return entityManager.getEntity(spawnItem(location.toLocation(), item).uniqueId)
    }

    override fun generateHyper(location: ConfiguredDoubleLocation) {
        val item = itemManager.getItemStack(parameter.generatorParameter.hyperItem)
        spawnItem(location.toLocation(), item)
    }

    private fun spawnItem(location: Location, item: ItemStack): Item {
        val droppedItem = location.world.spawnEntity(location, EntityType.DROPPED_ITEM) as Item
        droppedItem.itemStack = item
        return droppedItem
    }
}