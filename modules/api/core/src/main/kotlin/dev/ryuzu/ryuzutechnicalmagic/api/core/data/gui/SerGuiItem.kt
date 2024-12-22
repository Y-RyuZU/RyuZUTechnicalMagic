package dev.ryuzu.ryuzutechnicalmagic.api.core.data.gui

import kotlinx.serialization.Serializable

@Serializable
data class SerGuiItem(
    val items: Set<String>,
    val action: GuiAction,
)