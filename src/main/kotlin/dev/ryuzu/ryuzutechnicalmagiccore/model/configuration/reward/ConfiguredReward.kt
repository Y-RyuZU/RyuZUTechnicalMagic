package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.reward

data class ConfiguredReward(
    val name: String,
    val description: List<String>,
    val message: String,
    val exp: Int,
    val gold: Int,
    val items: Map<String, Int>
)
