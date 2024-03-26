package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.general

data class ConfiguredGeneratorParameter(
    val littleStarItem: String,
    val bigStarItem: String,
    val starLostScatter: Double = 0.2,
    val hyperItem: String,
    val itemTable: HashMap<Int, LinkedHashSet<String>>
)
