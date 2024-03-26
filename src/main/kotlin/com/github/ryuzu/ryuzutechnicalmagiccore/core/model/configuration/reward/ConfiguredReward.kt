package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.reward

data class ConfiguredReward(
    val name: String,
    val description: List<String>,
    val message: String,
    val exp: Int,
    val gold: Int,
    val items: HashMap<String, Int>
)
