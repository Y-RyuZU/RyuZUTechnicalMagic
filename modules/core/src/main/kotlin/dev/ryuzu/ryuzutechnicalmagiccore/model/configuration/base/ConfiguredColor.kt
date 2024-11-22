package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.ConfiguredParserUtil.fromStringPart
import kotlinx.serialization.Serializable
import org.koin.core.annotation.Single

@Serializable
data class ConfiguredColor(val r: Int, val g: Int, val b: Int) {
    constructor(color: String) : this(
        fromStringPart(color, 0, 3),
        fromStringPart(color, 1, 3),
        fromStringPart(color, 2, 3)
    )

    fun toHex(): String = String.format("#%02X%02X%02X", r, g, b)
}