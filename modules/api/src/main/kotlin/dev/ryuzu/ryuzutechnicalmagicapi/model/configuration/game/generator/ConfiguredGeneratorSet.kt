package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.game.generator

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<ConfiguredIntVector, ConfiguredStarGenerator>,
    val item: Map<ConfiguredIntVector, ConfiguredItemGenerator>
)
