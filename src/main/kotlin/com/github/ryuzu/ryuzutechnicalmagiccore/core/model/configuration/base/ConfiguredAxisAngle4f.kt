package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base

import com.fasterxml.jackson.annotation.JsonCreator
import org.joml.AxisAngle4f
import kotlin.math.sqrt
import kotlin.random.Random

class ConfiguredAxisAngle4f(
    val angle: Float = 0.0f,
    val x: Float = 0.0f,
    val y: Float = 0.0f,
    val z: Float = 0.0f
) : AxisAngle4f(angle, x, y, z) {
    @JsonCreator
    constructor(vector: String) : this(
        fromStringPart(vector, 0),
        fromStringPart(vector, 1),
        fromStringPart(vector, 2),
        fromStringPart(vector, 3)
    )

    companion object {
        private fun fromStringPart(vector: String, index: Int): Float {
            val split = vector.split(",")

            if (split.size != 4) {
                throw IllegalArgumentException("Invalid vector format, expected 4 parts but got ${split.size}")
            }

            return split[index].toFloatOrNull()
                ?: throw NumberFormatException("Invalid vector format, expected float values")
        }
    }
}