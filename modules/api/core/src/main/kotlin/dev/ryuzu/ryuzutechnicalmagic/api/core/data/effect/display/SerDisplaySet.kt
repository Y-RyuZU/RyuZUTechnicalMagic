package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.display

import kotlinx.serialization.Serializable

@Serializable
data class SerDisplaySet(
    val displays: Set<ISerDisplay> = emptySet(),
)
