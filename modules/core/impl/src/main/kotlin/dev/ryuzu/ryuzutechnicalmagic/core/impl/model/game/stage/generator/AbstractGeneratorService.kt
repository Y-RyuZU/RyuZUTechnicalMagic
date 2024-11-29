package dev.ryuzu.ryuzutechnicalmagic.core.impl.model.game.stage.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.event.data.item.PlayerPickUpEvent
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.stage.ConfiguredStage
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneralParameter
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IEntity
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.IGameService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.generator.IGeneratorService
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.generator.StarStockData
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISchedulerFactory
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.ISimpleScheduler
import dev.ryuzu.ryuzutechnicalmagic.api.core.util.MathUtility.Companion.nextGaussian
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.effect.IEffectService
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.random.Random

abstract class AbstractGeneratorService(
    protected val gameService: IGameService,
    protected val stage: ConfiguredStage
) : IGeneratorService, KoinComponent {
    private val schedulerFactory: ISchedulerFactory by inject()
    protected val effectService: IEffectService by inject()
    protected val parameter: ConfiguredGeneralParameter by inject()

    private val starStocks: MutableMap<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator.ConfiguredStarGenerator, StarStockData> = mutableMapOf()
    private val itemStocks: MutableMap<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator.ConfiguredItemGenerator, MutableSet<IEntity>> = mutableMapOf()

    protected val scheduler: ISimpleScheduler =
        schedulerFactory.createSimpleScheduler().whileSchedule { _, count ->
            if (count % 20L == 0L) return@whileSchedule
            val phase = gameService.getPhase().toDouble()

            stage.generators.item.entries.forEach { (vector, item) ->
                if (item.maxStock <= (itemStocks.getOrPut(item) { mutableSetOf() }.size)) return@forEach
                val location = item.getGeneratePoint(vector).toLocation(gameService.world)
                if (count % item.period == 0L)
                    if (Random.nextDouble() > item.unique)
                        itemStocks[item]?.add(generateItem(location, getRarityWithGaussian(phase)))
                    else
                        generateHyper(location)
            }
            stage.generators.star.entries.forEach { (vector, star) ->
                if (star.maxStock <= (starStocks.getOrPut(star) { StarStockData() }.getStock())) return@forEach
                if (count % star.period == 0L)
                    starStocks[star]?.addStock(
                        generateStar(
                            star.getGeneratePoint(vector).toLocation(gameService.world),
                            Random.nextInt(star.min, star.max + 1)
                        )
                    )
            }
        }

    init {
        scheduler.runSync()
    }

    override fun stop() = scheduler.cancel()

    protected open fun onPickup(event: PlayerPickUpEvent) {
        itemStocks.values.forEach {
            it.remove(event.itemEntity)
        }
        starStocks.values.forEach {
            it.bigStars.remove(event.itemEntity)
            it.littleStars.remove(event.itemEntity)
        }

        if (event.item.id == parameter.generatorParameter.littleStarItem || event.item.id == parameter.generatorParameter.bigStarItem) {
            event.item = event.item.copy(amount = 0)
            gameService.getGamePlayer(event.player).star += event.item.amount * if(event.item.id == parameter.generatorParameter.littleStarItem) 1 else 10
            effectService.playEffect(parameter.generatorParameter.effect, "StarPickup", event.player)
        }
        if (stage.itemTable.values.flatten().contains(event.item.id)) {
            effectService.playEffect(parameter.generatorParameter.effect, "ItemPickup", event.player)
        }
    }

    private fun getRarityWithGaussian(mean: Double): Int {
        val rand = Random.nextGaussian() * VARIANCE
        val result = mean + rand
        return result.coerceIn(0.0, 99.9).toInt() / 20 + 1
    }

    companion object {
        private const val VARIANCE = 100 / 6.0 // 約16.6667
    }
}