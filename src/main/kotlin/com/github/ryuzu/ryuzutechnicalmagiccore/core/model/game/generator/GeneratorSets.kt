package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.ConfiguredLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.property.ItemGeneratorProperty
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator.property.StarGeneratorProperty

data class GeneratorSets(
    val starGenerators: HashMap<ConfiguredLocation, StarGeneratorProperty>,
    val itemGenerators: HashMap<ConfiguredLocation, ItemGeneratorProperty>
)
