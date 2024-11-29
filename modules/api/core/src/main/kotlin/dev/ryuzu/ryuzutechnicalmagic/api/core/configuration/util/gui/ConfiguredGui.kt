package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.util.gui

data class ConfiguredGui(
    val name: String,
    val rows: Int,
    val items: Map<Int, dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.util.gui.ConfiguredGuiItem>,
)