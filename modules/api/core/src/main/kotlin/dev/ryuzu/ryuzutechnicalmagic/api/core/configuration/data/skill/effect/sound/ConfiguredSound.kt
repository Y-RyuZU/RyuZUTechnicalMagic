package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.skill.effect.sound

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredSound(
    val id: String,
    val volume: Float,
    val pitch: Float,
    val delay: Long
) {
    constructor(vector: String) : this(
        fromStringPart(vector, 0, 4),
        fromStringPart(vector, 1, 4),
        fromStringPart(vector, 2, 4),
        fromStringPart(vector, 3, 4)
    )
}
