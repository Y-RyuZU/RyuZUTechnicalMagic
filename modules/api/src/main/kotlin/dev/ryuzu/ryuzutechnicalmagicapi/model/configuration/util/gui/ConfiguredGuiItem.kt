package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.gui

data class ConfiguredGuiItem(
    val items: Set<String>,
    val action: GuiAction,
)