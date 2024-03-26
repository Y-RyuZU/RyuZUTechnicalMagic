package com.github.ryuzu.ryuzutechnicalmagiccore.core.util.wrapper.bossbar

import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@Single
class BossBarFactory : KoinComponent {
    fun createBossBarService(): IBossBarService = get()
}