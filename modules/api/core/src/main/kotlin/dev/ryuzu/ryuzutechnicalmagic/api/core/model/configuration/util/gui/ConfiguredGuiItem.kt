package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui

data class ConfiguredGuiItem(
    val items: Set<String>,
    val action: dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.GuiAction,
)