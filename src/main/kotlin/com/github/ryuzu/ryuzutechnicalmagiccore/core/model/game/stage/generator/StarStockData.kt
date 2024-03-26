package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.generator

import java.util.UUID

data class StarStockData(
    val bigStars: MutableSet<UUID> = mutableSetOf(),
    val littleStars: MutableSet<UUID> = mutableSetOf()
) {
    fun getStock(): Int = bigStars.size + littleStars.size
    fun addStock(starStock: StarStockData) {
        bigStars.addAll(starStock.bigStars)
        littleStars.addAll(starStock.littleStars)
    }
}
