package dev.ryuzu.ryuzutechnicalmagic.api.core.data.effect.display

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed interface ISerDisplay {
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
    val transformation: SerTransformation
    val animation: List<SerAnimationDisplay>
}

@SerialName("block")
@Serializable
data class SerBlockDisplay(
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
    override val transformation: SerTransformation = SerTransformation(),
    override val animation: List<SerAnimationDisplay>
) : ISerDisplay

@SerialName("item")
@Serializable
data class SerItemDisplay(
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
    override val transformation: SerTransformation = SerTransformation(),
    override val animation: List<SerAnimationDisplay>,
    val item: String
) : ISerDisplay

@SerialName("text")
@Serializable
data class SerTextDisplay(
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
    override val transformation: SerTransformation = SerTransformation(),
    override val animation: List<SerAnimationDisplay> = emptyList(),
    val texts: List<String>,
    val alignment: String = "CENTER",
    val background: String = "GRAY",
    val lineWidth: Int = 200,
    val opacity: Byte = -1,
    val seeThrough: Boolean = false,
    val shadowed: Boolean = false,
) : ISerDisplay