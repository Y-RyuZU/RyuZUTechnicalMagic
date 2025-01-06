package dev.ryuzu.ryuzutechnicalmagic.api.game.data.reward

import kotlinx.serialization.Serializable

@Serializable
data class SerReward(
    val name: String,
    val description: List<String>,
    val message: String,
    val exp: Int,
    val gold: Int,
    val items: Map<String, Int>
)
