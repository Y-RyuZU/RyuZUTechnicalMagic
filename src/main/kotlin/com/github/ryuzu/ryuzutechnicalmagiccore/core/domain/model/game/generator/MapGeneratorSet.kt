package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration.ConfiguredLocation

data class MapGeneratorSet(
    val starGenerators: HashMap<ConfiguredLocation, StarGenerator>,
    val itemGenerators: HashMap<ConfiguredLocation, ItemGenerator>
)
