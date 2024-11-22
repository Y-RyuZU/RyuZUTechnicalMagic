package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.effect.particle.set

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredDoubleVector
import org.joml.Vector3d
import kotlin.random.Random

enum class ParticleAngle {
    RAW,
    HORIZONTAL,
    VERTICAL,
    RANDOM;

    fun getVector(v: ConfiguredDoubleVector): ConfiguredDoubleVector {
        return when (this) {
            RAW -> v
            HORIZONTAL -> ConfiguredDoubleVector(
                if (v.y == 0.0) randomHorizontalVector() else v.copy(y = 0.0).normalize()
            )
            VERTICAL -> ConfiguredDoubleVector(0.0, 1.0, 0.0)
            RANDOM -> ConfiguredDoubleVector(randomVector())
        }
    }

    private fun randomVector(): Vector3d {
        var x: Double
        var y: Double
        var z: Double

        do {
            x = Random.nextDouble(-1.0, 1.0)
            y = Random.nextDouble(-1.0, 1.0)
            z = Random.nextDouble(-1.0, 1.0)
        } while (x == 0.0 && y == 0.0 && z == 0.0)

        return Vector3d(x, y, z).normalize()
    }

    private fun randomHorizontalVector(): Vector3d {
        var x: Double
        var z: Double

        do {
            x = Random.nextDouble(-1.0, 1.0)
            z = Random.nextDouble(-1.0, 1.0)
        } while (x == 0.0 && z == 0.0)

        return Vector3d(x, 0.0, z).normalize()
    }
}