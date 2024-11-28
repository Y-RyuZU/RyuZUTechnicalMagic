package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<ConfiguredIntVector, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.game.generator.ConfiguredStarGenerator>,
    val item: Map<ConfiguredIntVector, ConfiguredItemGenerator>
)
