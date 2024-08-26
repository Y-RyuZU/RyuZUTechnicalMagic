package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.effect.particle.set

import org.joml.Vector3d

data class OrthonormalBasis(
    val u: Vector3d,
    val v: Vector3d,
    val w: Vector3d
) {
    companion object {
        fun from(u: Vector3d): OrthonormalBasis {
            val uNorm = Vector3d(u).normalize()
            val (v, w) = computeOrthogonalBasis(uNorm)
            return OrthonormalBasis(uNorm, v, w)
        }

        private fun computeOrthogonalBasis(u: Vector3d): Pair<Vector3d, Vector3d> {
            val v = if (Math.abs(u.x) > Math.abs(u.y))
                Vector3d(-u.y, u.x, 0.0)
            else
                Vector3d(0.0, -u.z, u.y)

            val w = Vector3d().apply { set(u).cross(v).normalize() }

            return Pair(v, w)
        }
    }
}
