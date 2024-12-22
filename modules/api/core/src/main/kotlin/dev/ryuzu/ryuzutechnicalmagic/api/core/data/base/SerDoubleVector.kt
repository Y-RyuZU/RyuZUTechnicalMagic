package dev.ryuzu.ryuzutechnicalmagic.api.core.data.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.ConfiguredParserUtil.fromStringPart
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.IConfiguredParticle
import dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.particle.set.OrthonormalBasis
import kotlinx.serialization.Serializable
import org.joml.Vector3d
import org.joml.Vector3f
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.random.Random

@Serializable
data class SerDoubleVector(
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

    fun toIntVector(): SerIntVector {
        return SerIntVector(
            x.toInt(),
            y.toInt(),
            z.toInt()
        )
    }

    fun toLocation(world: String): SerDoubleLocation {
        return SerDoubleLocation(world, this)
    }

    fun toFloat(): Vector3f {
        return Vector3f(x.toFloat(), y.toFloat(), z.toFloat())
    }

    fun calculateCirclePoint(
        orthonormalBasis: OrthonormalBasis,
        radian: Double,
        radius: Double
    ): SerDoubleVector =
        SerDoubleVector(
            this.copy()
                .add(Vector3d(orthonormalBasis.u).mul(cos(radian) * radius))
                .add(Vector3d(orthonormalBasis.w).mul(sin(radian) * radius))
        )


    fun calculateCircleExtraVector(
        particle: IConfiguredParticle,
        vertex: SerDoubleVector,
        orthonormalBasis: OrthonormalBasis
    ): SerDoubleVector =
        if (particle.count == 0)
            SerDoubleVector(vertex.copy().sub(this).normalize())
        else
            SerDoubleVector(orthonormalBasis.u)


    companion object {
        fun random(): SerDoubleVector {
            val x = Random.nextDouble() * 2 - 1
            val y = Random.nextDouble() * 2 - 1
            val z = Random.nextDouble() * 2 - 1

            // 生成したランダム値の大きさ（長さ）を計算
            val magnitude = sqrt(x * x + y * y + z * z)

            // 大きさで各成分を割り、正規化されたベクトルを生成
            return SerDoubleVector(x / magnitude, y / magnitude, z / magnitude)
        }
    }
}