package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display

data class ConfiguredDisplay(
    val type: DisplayType = DisplayType.ITEM,
    val billboard: String = "CENTER",
    val blockLight: Int = 15,
    val skyLight: Int = 15,
    val height: Float = 0F,
    val width: Float = 0F,
    val glowColor: String = "WHITE",
    val interpolationDelay: Int = 0,
    val interpolationDuration: Int = 0,
    val teleportDuration: Int = 0,
    val shadowRadius: Float = 0F,
    val shadowStrength: Float = 1F,
    val viewRange: Float = 1F,
    val transformation: TransformationData,
    val animation: List<ConfiguredAnimationDisplay>
)