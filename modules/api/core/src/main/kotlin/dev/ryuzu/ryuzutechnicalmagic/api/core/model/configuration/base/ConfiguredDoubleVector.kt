package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import org.joml.Vector3d
import org.joml.Vector3f
import kotlin.math.sqrt
import kotlin.random.Random
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredDoubleVector(
    var x: Double = 0.0,
    val y: Double = 0.0,
    val z: Double = 0.0
) : Vector3d(x, y, z) {
    constructor(vector: String) : this(
        fromStringPart(vector, 0, 3),
        fromStringPart(vector, 1, 3),
        fromStringPart(vector, 2, 3)
    )

    constructor(vector: Vector3d) : this(vector.x, vector.y, vector.z)

    fun toIntVector(): ConfiguredIntVector {
        return ConfiguredIntVector(x.toInt(), y.toInt(), z.toInt())
    }

    fun toLocation(world: String): ConfiguredDoubleLocation {
        return ConfiguredDoubleLocation(world, this)
    }

    fun toFloat(): Vector3f {
        return Vector3f(x.toFloat(), y.toFloat(), z.toFloat())
    }

    companion object {
        fun random(): ConfiguredDoubleVector {
            val x = Random.nextDouble() * 2 - 1
            val y = Random.nextDouble() * 2 - 1
            val z = Random.nextDouble() * 2 - 1

            // 生成したランダム値の大きさ（長さ）を計算
            val magnitude = sqrt(x * x + y * y + z * z)

            // 大きさで各成分を割り、正規化されたベクトルを生成
            return ConfiguredDoubleVector(x / magnitude, y / magnitude, z / magnitude)
        }
    }
}