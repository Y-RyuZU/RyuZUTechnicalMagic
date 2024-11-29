package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator

interface IConfiguredGenerator {
    val period: Int
    val offY: Double
    val radius: Double
    val maxStock: Int
    val multiply: Double
}