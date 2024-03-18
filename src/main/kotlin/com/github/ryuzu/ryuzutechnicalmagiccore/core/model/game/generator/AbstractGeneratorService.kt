package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.IConfiguredGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.IGameService
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.scheduler.ISimpleScheduler
import com.github.ryuzu.ryuzutechnicalmagiccore.minecraft.implementation.scheduler.SimpleSchedulerFactory
import com.github.ryuzu.ryuzutechnicalmagiccore.core.util.MathUtility.Companion.nextGaussian
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.math.pow
import kotlin.random.Random

abstract class AbstractGeneratorService(
    private val generatorSets: GeneratorSets,
    private val gameService: IGameService
) : IGeneratorService, KoinComponent {
    private val schedulerFactory: SimpleSchedulerFactory by inject()

    protected val scheduler: ISimpleScheduler =
        schedulerFactory.createScheduler().schedule(0, Long.MAX_VALUE) { _, count ->
            if (count % 20L == 0L) return@schedule
            val phase = gameService.getPhase().toDouble()

            generatorSets.itemGenerators.forEach {
                if (count % it.period == 0L)
                    generateItem(
                        gameService.world,
                        it.getGeneratePoint(),
                        it,
                        getRarityWithGaussian(it.rarity * it.multiply.pow(phase))
                    )
            }
            generatorSets.starGenerators.forEach {
                if (count % it.period == 0L)
                    generateStar(gameService.world, it.getGeneratePoint(), it, Random.nextInt(it.min, it.max + 1))
            }
        }

    override fun start() = scheduler.runSync()
    override fun stop() = scheduler.cancel()

    protected abstract fun generateItem(
        world: String,
        vector: ConfiguredDoubleVector,
        property: IConfiguredGenerator,
        rarity: Int
    )

    protected abstract fun generateStar(
        world: String,
        vector: ConfiguredDoubleVector,
        property: IConfiguredGenerator,
        amount: Int
    )

    private fun getRarityWithGaussian(mean: Double): Int {
        val rand = Random.nextGaussian() * VARIANCE
        val result = mean + rand
        return result.coerceIn(0.0, 100.0).toInt()
    }

    companion object {
        private const val VARIANCE = 100 / 6.0 // 約16.6667
    }
}