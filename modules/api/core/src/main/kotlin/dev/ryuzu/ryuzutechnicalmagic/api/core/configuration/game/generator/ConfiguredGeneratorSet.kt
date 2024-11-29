package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector

data class ConfiguredGeneratorSet(
    val star: Map<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator.ConfiguredStarGenerator>,
    val item: Map<dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector, dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.game.generator.ConfiguredItemGenerator>
)
