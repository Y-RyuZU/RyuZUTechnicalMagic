package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui

data class ConfiguredGui(
    val name: String,
    val rows: Int,
    val items: Map<Int, dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.util.gui.ConfiguredGuiItem>,
)