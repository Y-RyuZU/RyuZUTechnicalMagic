package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable

@Serializable
data class ConfiguredScalableColor(val color: ConfiguredColor, val size: Float = 1.0f) {

    constructor(scalableColor: String) : this(
        ConfiguredColor(
            fromStringPart(scalableColor, 0, 4),
            fromStringPart(scalableColor, 1, 4),
            fromStringPart(scalableColor, 2, 4)
        ),
        fromStringPart(scalableColor, 3, 4)
    )
}