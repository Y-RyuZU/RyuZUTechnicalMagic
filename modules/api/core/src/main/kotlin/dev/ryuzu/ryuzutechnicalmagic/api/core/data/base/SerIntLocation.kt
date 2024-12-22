package dev.ryuzu.ryuzutechnicalmagic.api.core.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class SerIntLocation(val world: String, val vector: SerIntVector) {

    constructor(location: String) : this(
        fromStringPart(location, 0, 4),
        SerIntVector(
            fromStringPart(location, 1, 4),
            fromStringPart(location, 2, 4),
            fromStringPart(location, 3, 4)
        )
    )

    fun toDoubleLocation(): SerDoubleLocation {
        return SerDoubleLocation(world, vector.toDoubleVector())
    }
}