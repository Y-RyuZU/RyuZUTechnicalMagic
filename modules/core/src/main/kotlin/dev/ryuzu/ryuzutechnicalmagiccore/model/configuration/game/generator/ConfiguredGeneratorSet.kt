package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.game.generator

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<ConfiguredIntVector, ConfiguredStarGenerator>,
    val item: Map<ConfiguredIntVector, ConfiguredItemGenerator>
)
