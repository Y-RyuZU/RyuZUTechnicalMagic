package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.persistent

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.lang.Language

data class PlayerSettingEntity (
    val quickSpell: Boolean = false,
    val particlePriority: Int = 10,
    val language: Language = Language.JAPANESE
)