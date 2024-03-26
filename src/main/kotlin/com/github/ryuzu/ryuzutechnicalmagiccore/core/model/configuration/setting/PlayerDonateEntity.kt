package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.setting

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IItem
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

data class PlayerDonateEntity(
    val flag: Boolean = false,
)
