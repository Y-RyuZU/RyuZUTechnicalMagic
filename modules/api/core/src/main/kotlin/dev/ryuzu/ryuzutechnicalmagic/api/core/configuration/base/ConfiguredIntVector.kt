package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredIntVector(val x: Int, val y: Int, val z: Int) {

    constructor(vector: String) : this(
        fromStringPart(vector, 0, 3),
        fromStringPart(vector, 1, 3),
        fromStringPart(vector, 2, 3)
    )

    fun toLocation(world: String): dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntLocation {
        return dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntLocation(world, this)
    }

    fun toDoubleVector(): dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleVector {
        return dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredDoubleVector(
            x.toDouble(),
            y.toDouble(),
            z.toDouble()
        )
    }
}