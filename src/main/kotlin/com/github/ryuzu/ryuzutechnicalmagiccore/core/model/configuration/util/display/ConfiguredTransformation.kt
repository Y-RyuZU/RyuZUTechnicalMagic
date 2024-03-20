package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import org.joml.AxisAngle4f

data class ConfiguredTransformation(
    val translation: ConfiguredDoubleVector,
    val yawPitchRoll: AxisAngle4f,
    val scale: ConfiguredDoubleVector,
    val yawPitchRoll2: AxisAngle4f
)