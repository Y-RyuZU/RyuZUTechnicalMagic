package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IEntity

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
