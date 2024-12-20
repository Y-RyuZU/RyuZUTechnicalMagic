package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredDoubleLocation(
    val world: String,
    val vector: ConfiguredDoubleVector
) {
    constructor(location: String) : this(
        fromStringPart<String>(location, 0, 4),
        ConfiguredDoubleVector(
            fromStringPart(location, 1, 4),
            fromStringPart(location, 2, 4),
            fromStringPart(location, 3, 4)
        )
    )

    fun toIntLocation(): ConfiguredIntLocation {
        return ConfiguredIntLocation(world, vector.toIntVector())
    }
}