package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredItemGenerator
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.generator.ConfiguredStarGenerator

data class GeneratorSets(
    val starGenerators: List<ConfiguredStarGenerator>,
    val itemGenerators: List<ConfiguredItemGenerator>
)
