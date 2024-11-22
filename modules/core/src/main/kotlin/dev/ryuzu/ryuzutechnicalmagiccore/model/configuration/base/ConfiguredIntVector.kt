package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredIntVector(val x: Int, val y: Int, val z: Int) {

    constructor(vector: String) : this(
        fromStringPart(vector, 0, 3),
        fromStringPart(vector, 1, 3),
        fromStringPart(vector, 2, 3)
    )

    fun toLocation(world: String): ConfiguredIntLocation {
        return ConfiguredIntLocation(world, this)
    }

    fun toDoubleVector(): ConfiguredDoubleVector {
        return ConfiguredDoubleVector(x.toDouble(), y.toDouble(), z.toDouble())
    }
}