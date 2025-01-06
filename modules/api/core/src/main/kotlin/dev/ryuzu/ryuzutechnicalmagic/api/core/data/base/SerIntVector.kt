package dev.ryuzu.ryuzutechnicalmagic.api.core.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.SerializableObjectUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class SerIntVector(val x: Int, val y: Int, val z: Int) {

    constructor(vector: String) : this(
        fromStringPart(vector, 0, 3),
        fromStringPart(vector, 1, 3),
        fromStringPart(vector, 2, 3)
    )

    fun toLocation(world: String): SerIntLocation {
        return SerIntLocation(world, this)
    }

    fun toDoubleVector(): SerDoubleVector {
        return SerDoubleVector(
            x.toDouble(),
            y.toDouble(),
            z.toDouble()
        )
    }
}