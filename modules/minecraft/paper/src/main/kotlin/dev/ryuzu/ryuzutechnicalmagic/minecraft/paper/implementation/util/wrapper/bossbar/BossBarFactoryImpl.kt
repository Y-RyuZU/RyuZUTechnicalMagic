package dev.ryuzu.ryuzutechnicalmagic.minecraft.paper.implementation.util.wrapper.bossbar

import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar.IBossBarFactory
import dev.ryuzu.ryuzutechnicalmagic.api.minecraft.adapter.bossbar.IBossBarObject
import org.koin.core.annotation.Single
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

@Single([IBossBarFactory::class])
class BossBarFactoryImpl : IBossBarFactory, KoinComponent {
    override fun createBossBar(): IBossBarObject = get()
}