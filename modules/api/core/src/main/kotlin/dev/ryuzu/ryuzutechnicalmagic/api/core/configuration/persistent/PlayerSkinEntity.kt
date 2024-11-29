package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.persistent

data class PlayerSkinEntity(
    val skins: Map<String, WeaponSkinEntity> = emptyMap(),
)

data class WeaponSkinEntity(
    val hasSkins: List<String>,
    val selectedSkin: Int
)