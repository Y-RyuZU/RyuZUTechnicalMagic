package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredItemGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredStarGenerator

data class ConfiguredGeneratorSet(
    val starGenerators: Set<ConfiguredStarGenerator>,
    val itemGenerators: Set<ConfiguredItemGenerator>
)
