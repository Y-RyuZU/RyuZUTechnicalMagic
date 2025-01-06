package dev.ryuzu.ryuzutechnicalmagic.api.permanent.data

data class PlayerSkinEntity(
    val skins: Map<String, WeaponSkinEntity> = emptyMap(),
)

data class WeaponSkinEntity(
    val hasSkins: List<String>,
    val selectedSkin: Int
)
