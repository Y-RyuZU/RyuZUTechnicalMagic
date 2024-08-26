package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredAxisAngle4f
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector

data class ConfiguredTransformation(
    val translation: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    val yawPitchRoll: ConfiguredAxisAngle4f = ConfiguredAxisAngle4f(),
    val scale: ConfiguredDoubleVector = ConfiguredDoubleVector(),
    val yawPitchRoll2: ConfiguredAxisAngle4f = ConfiguredAxisAngle4f()
)