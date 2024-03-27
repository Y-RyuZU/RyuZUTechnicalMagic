package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredGeneratorSet
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredItemGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredStarGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.MathUtility.Companion.nextGaussian
import org.koin.core.component.inject
import org.koin.core.parameter.parametersOf
import java.util.UUID
import kotlin.random.Random

abstract class AbstractGeneratorService(
    private val gameService: IGameService
) : IGeneratorService {
    private val generatorSet: ConfiguredGeneratorSet by inject { parametersOf(gameService.world) }
    private val schedulerFactory: SimpleSchedulerFactory by inject()

    private val starStocks: HashMap<ConfiguredStarGenerator, StarStockData> = hashMapOf()
    private val itemStocks: HashMap<ConfiguredItemGenerator, MutableSet<UUID>> = hashMapOf()

    protected val scheduler: ISimpleScheduler =
        schedulerFactory.createScheduler().whileSchedule { _, count ->
            if (count % 20L == 0L) return@whileSchedule
            val phase = gameService.getPhase().toDouble()

            generatorSet.itemGenerators.forEach {
                if (it.maxStock <= (itemStocks.getOrPut(it) { mutableSetOf() }.size)) return@forEach
                val location = it.getGeneratePoint().toLocation(gameService.world)
                if (count % it.period == 0L)
                    if (Random.nextDouble() > it.unique)
                        itemStocks[it]?.add(generateItem(location, getRarityWithGaussian(phase)))
                    else
                        generateHyper(location)
            }
            generatorSet.starGenerators.forEach {
                if (it.maxStock <= (starStocks.getOrPut(it) { StarStockData() }.getStock())) return@forEach
                if (count % it.period == 0L)
                    starStocks[it]?.addStock(
                        generateStar(
                            it.getGeneratePoint().toLocation(gameService.world),
                            Random.nextInt(it.min, it.max + 1)
                        )
                    )
            }
        }

    init {
        scheduler.runSync()
    }

    override fun stop() = scheduler.cancel()

    protected fun onPickup(itemEntity: UUID) {
        itemStocks.values.forEach {
            it.remove(itemEntity)
        }
        starStocks.values.forEach {
            it.bigStars.remove(itemEntity)
            it.littleStars.remove(itemEntity)
        }
    }

    private fun getRarityWithGaussian(mean: Double): Int {
        val rand = Random.nextGaussian() * VARIANCE
        val result = mean + rand
        return result.coerceIn(0.0, 100.0).toInt() / 20
    }

    companion object {
        private const val VARIANCE = 100 / 6.0 // 約16.6667
    }
}