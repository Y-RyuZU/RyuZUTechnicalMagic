package dev.ryuzu.ryuzutechnicalmagic.api.core.data.gui

import kotlinx.serialization.Serializable

@Serializable
data class SerGui(
    val name: String,
    val rows: Int,
    val items: Map<Int, SerGuiItem>,
)