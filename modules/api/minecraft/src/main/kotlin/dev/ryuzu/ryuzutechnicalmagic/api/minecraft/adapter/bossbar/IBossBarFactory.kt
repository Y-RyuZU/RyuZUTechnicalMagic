package dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar

import dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.bossbar.ConfiguredBossBar
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.scheduler.UpdatePeriod

interface IBossBarFactory {
    fun createBossBar(): IBossBarObject
}