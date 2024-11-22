package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.util.gui

data class ConfiguredGui(
    val name: String,
    val rows: Int,
    val items: Map<Int, ConfiguredGuiItem>,
)