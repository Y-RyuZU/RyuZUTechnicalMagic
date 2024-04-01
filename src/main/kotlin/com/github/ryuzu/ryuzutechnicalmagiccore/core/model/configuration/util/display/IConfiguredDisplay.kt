package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.display

import com.fasterxml.jackson.annotation.JsonSubTypes
import com.fasterxml.jackson.annotation.JsonTypeInfo

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "Type")
@JsonSubTypes(
    JsonSubTypes.Type(value = IConfiguredDisplay.ConfiguredItemDisplay::class, name = "BLOCK"),
    JsonSubTypes.Type(value = IConfiguredDisplay.ConfiguredBlockDisplay::class, name = "ITEM"),
    JsonSubTypes.Type(value = IConfiguredDisplay.ConfiguredTextDisplay::class, name = "TEXT")
)
interface IConfiguredDisplay {
    val billboard: String
    val blockLight: Int
    val skyLight: Int
    val height: Float
    val width: Float
    val glowColor: String
    val interpolationDelay: Int
    val interpolationDuration: Int
    val teleportDuration: Int
    val shadowRadius: Float
    val shadowStrength: Float
    val viewRange: Float
    val transformation: ConfiguredTransformation
    val animation: List<ConfiguredAnimationDisplay>

    data class ConfiguredItemDisplay(
        override val billboard: String = "CENTER",
        override val blockLight: Int = 15,
        override val skyLight: Int = 15,
        override val height: Float = 0F,
        override val width: Float = 0F,
        override val glowColor: String = "WHITE",
        override val interpolationDelay: Int = 0,
        override val interpolationDuration: Int = 0,
        override val teleportDuration: Int = 0,
        override val shadowRadius: Float = 0F,
        override val shadowStrength: Float = 1F,
        override val viewRange: Float = 1F,
        override val transformation: ConfiguredTransformation = ConfiguredTransformation(),
        override val animation: List<ConfiguredAnimationDisplay>
    ) : IConfiguredDisplay

    data class ConfiguredBlockDisplay(
        override val billboard: String = "CENTER",
        override val blockLight: Int = 15,
        override val skyLight: Int = 15,
        override val height: Float = 0F,
        override val width: Float = 0F,
        override val glowColor: String = "WHITE",
        override val interpolationDelay: Int = 0,
        override val interpolationDuration: Int = 0,
        override val teleportDuration: Int = 0,
        override val shadowRadius: Float = 0F,
        override val shadowStrength: Float = 1F,
        override val viewRange: Float = 1F,
        override val transformation: ConfiguredTransformation = ConfiguredTransformation(),
        override val animation: List<ConfiguredAnimationDisplay>
    ) : IConfiguredDisplay

    data class ConfiguredTextDisplay(
        override val billboard: String = "CENTER",
        override val blockLight: Int = 15,
        override val skyLight: Int = 15,
        override val height: Float = 0F,
        override val width: Float = 0F,
        override val glowColor: String = "WHITE",
        override val interpolationDelay: Int = 0,
        override val interpolationDuration: Int = 0,
        override val teleportDuration: Int = 0,
        override val shadowRadius: Float = 0F,
        override val shadowStrength: Float = 1F,
        override val viewRange: Float = 1F,
        override val transformation: ConfiguredTransformation = ConfiguredTransformation(),
        override val animation: List<ConfiguredAnimationDisplay> = emptyList(),
        val texts: List<String>,
        val alignment: String = "CENTER",
        val background: String = "GRAY",
        val lineWidth: Int = 200,
        val opacity: Byte = -1,
        val seeThrough: Boolean = false,
        val shadowed: Boolean = false,
    ) : IConfiguredDisplay
}