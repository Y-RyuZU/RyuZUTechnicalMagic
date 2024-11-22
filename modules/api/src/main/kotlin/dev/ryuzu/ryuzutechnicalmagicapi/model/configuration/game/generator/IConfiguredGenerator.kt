package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.generator

interface IConfiguredGenerator {
    val period: Int
    val offY: Double
    val radius: Double
    val maxStock: Int
    val multiply: Double
}