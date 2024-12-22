package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.display

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerAxisAngle4f
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerDoubleVector
import kotlinx.serialization.Serializable


@Serializable
data class SerTransformation(
    val translation: SerDoubleVector = SerDoubleVector(),
    val yawPitchRoll: SerAxisAngle4f = SerAxisAngle4f(),
    val scale: SerDoubleVector = SerDoubleVector(),
    val yawPitchRoll2: SerAxisAngle4f = SerAxisAngle4f()
)