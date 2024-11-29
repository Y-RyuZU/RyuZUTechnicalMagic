package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredIntLocation(val world: String, val vector: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector) {

    constructor(location: String) : this(
        fromStringPart(location, 0, 4),
        dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.base.ConfiguredIntVector(
            fromStringPart(location, 1, 4),
            fromStringPart(location, 2, 4),
            fromStringPart(location, 3, 4)
        )
    )

    fun toDoubleLocation(): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, vector.toDoubleVector())
    }
}