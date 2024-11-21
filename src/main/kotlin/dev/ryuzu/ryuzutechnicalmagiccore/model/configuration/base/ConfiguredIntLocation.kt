package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Single

@Serializable
data class ConfiguredIntLocation(val world: String, val vector: ConfiguredIntVector) {

    constructor(location: String) : this(
        fromStringPart(location, 0, 4),
        ConfiguredIntVector(
            fromStringPart(location, 1, 4),
            fromStringPart(location, 2, 4),
            fromStringPart(location, 3, 4)
        )
    )

    fun toDoubleLocation(): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, vector.toDoubleVector())
    }
}