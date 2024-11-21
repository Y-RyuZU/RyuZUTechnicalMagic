package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent

data class PlayerSkinEntity(
    val skins: Map<String, WeaponSkinEntity> = emptyMap(),
)

data class WeaponSkinEntity(
    val hasSkins: List<String>,
    val selectedSkin: Int
)
