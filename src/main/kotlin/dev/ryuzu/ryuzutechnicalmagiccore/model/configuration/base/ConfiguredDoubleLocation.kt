package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Single

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