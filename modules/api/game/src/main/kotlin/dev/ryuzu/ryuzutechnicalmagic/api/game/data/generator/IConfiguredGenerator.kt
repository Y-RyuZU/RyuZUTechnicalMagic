package dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator

interface IConfiguredGenerator {
    val period: Int
    val offY: Double
    val radius: Double
    val maxStock: Int
    val multiply: Double
}