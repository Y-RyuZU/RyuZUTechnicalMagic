package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.display

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredAxisAngle4f
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredTransformation(
    val translation: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    val yawPitchRoll: ConfiguredAxisAngle4f = ConfiguredAxisAngle4f(),
    val scale: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    val yawPitchRoll2: ConfiguredAxisAngle4f = ConfiguredAxisAngle4f()
)