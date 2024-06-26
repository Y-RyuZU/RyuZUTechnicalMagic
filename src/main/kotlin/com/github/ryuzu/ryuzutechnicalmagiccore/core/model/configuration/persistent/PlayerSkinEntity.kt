package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.util.ConfiguredEffect

data class PlayerSkinEntity(
    val skins: Map<String, WeaponSkinEntity> = emptyMap(),
)

data class WeaponSkinEntity(
    val hasSkins: List<String>,
    val selectedSkin: Int
)
