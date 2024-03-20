package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.gui

data class ConfiguredGui(
    val name: String,
    val rows: Int,
    val items: HashMap<Int, ConfiguredGuiItem>,
)