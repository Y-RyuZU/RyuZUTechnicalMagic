package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.persistent

import dev.ryuzu.ryuzutechnicalmagiccore.model.lang.Language

data class PlayerSettingEntity (
    val quickSpell: Boolean = false,
    val particlePriority: Int = 10,
    val language: Language = Language.JAPANESE
)