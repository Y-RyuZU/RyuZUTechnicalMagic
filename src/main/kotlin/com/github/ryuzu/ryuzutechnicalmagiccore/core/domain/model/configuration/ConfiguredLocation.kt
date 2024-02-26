package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.configuration

import kotlin.jvm.Throws

data class ConfiguredLocation(val world: String, val Vector: ConfiguredIntVector) {
    companion object {
        @Throws(IllegalArgumentException::class, NumberFormatException::class)
        fun fromString(location: String): ConfiguredLocation {
            val split = location.split("-")
            if (split.size != 4) throw IllegalArgumentException("Invalid location format")
            return ConfiguredLocation(split[0], ConfiguredIntVector.fromString(split[1] + "-" + split[2] + "-" + split[3]))
        }
    }
}
