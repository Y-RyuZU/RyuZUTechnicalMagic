package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<ConfiguredIntVector, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.generator.ConfiguredStarGenerator>,
    val item: Map<ConfiguredIntVector, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.game.generator.ConfiguredItemGenerator>
)
