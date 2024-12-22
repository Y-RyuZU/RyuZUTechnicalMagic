package dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntVector

data class ConfiguredGeneratorSet(
    val star: Map<SerIntVector, dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator.ConfiguredStarGenerator>,
    val item: Map<SerIntVector, dev.ryuzu.ryuzutechnicalmagic.api.game.data.generator.ConfiguredItemGenerator>
)
