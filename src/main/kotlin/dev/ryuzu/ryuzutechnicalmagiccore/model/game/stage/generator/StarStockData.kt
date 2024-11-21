package dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.generator

import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IEntity

data class StarStockData(
    val bigStars: MutableSet<IEntity> = mutableSetOf(),
    val littleStars: MutableSet<IEntity> = mutableSetOf()
) {
    fun getStock(): Int = bigStars.size + littleStars.size
    fun addStock(starStock: StarStockData) {
        bigStars.addAll(starStock.bigStars)
        littleStars.addAll(starStock.littleStars)
    }
}
