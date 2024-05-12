package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.persistent

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.lang.Language

data class PlayerSettingEntity (
    val quickSpell: Boolean = false,
    val particlePriority: Int = 10,
    val language: Language = Language.JAPANESE
)