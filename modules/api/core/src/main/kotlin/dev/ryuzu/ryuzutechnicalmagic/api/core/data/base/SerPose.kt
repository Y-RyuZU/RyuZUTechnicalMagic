package dev.ryuzu.ryuzutechnicalmagic.api.core.data.base

import kotlinx.serialization.Serializable

@Serializable
data class SerPose(val location: SerDoubleLocation, val direction: SerDoubleVector)