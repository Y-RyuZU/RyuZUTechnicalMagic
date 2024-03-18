package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.effect.display

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredDoubleVector
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntVector

data class TransformationData(
    val translation: ConfiguredDoubleVector,
    val yawPitchRoll: ConfiguredDoubleVector,
    val scale: ConfiguredDoubleVector,
    val yawPitchRoll2: ConfiguredDoubleVector
)