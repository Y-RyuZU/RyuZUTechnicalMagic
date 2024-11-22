package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.persistent

import dev.ryuzu.ryuzutechnicalmagicapi.model.lang.Language

data class PlayerSettingEntity (
    val quickSpell: Boolean = false,
    val particlePriority: Int = 10,
    val language: Language = Language.JAPANESE
)