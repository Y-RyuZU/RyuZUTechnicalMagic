package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.stage

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredItemGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredStarGenerator

data class ConfiguredGeneratorSet(
    val starGenerators: List<ConfiguredStarGenerator>,
    val itemGenerators: List<ConfiguredItemGenerator>
)
