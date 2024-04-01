package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<ConfiguredIntVector, ConfiguredStarGenerator>,
    val item: Map<ConfiguredIntVector, ConfiguredItemGenerator>
)
