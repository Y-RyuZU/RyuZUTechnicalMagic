package dev.ryuzu.ryuzutechnicalmagic.api.core.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.SerializableObjectUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class SerDoubleLocation(
    val world: String,
    val vector: SerDoubleVector
) {
    constructor(location: String) : this(
        fromStringPart<String>(location, 0, 4),
        SerDoubleVector(
            fromStringPart(location, 1, 4),
            fromStringPart(location, 2, 4),
            fromStringPart(location, 3, 4)
        )
    )

    fun toIntLocation(): SerIntLocation {
        return SerIntLocation(world, vector.toIntVector())
    }
}