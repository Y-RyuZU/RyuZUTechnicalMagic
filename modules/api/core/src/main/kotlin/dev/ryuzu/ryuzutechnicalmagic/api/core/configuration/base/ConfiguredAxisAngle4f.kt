package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable
import org.joml.AxisAngle4f

@Serializable
data class ConfiguredAxisAngle4f(
    val angle: Float = 0.0f,
    val x: Float = 0.0f,
    val y: Float = 0.0f,
    val z: Float = 0.0f
) : AxisAngle4f(angle, x, y, z) {
    constructor(vector: String) : this(
        fromStringPart<Float>(vector, 0, 4),
        fromStringPart(vector, 1, 4),
        fromStringPart(vector, 2, 4),
        fromStringPart(vector, 3, 4)
    )
}