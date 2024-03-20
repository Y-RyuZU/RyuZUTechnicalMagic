package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.generator

import org.koin.core.component.KoinComponent

interface IGeneratorService : KoinComponent {
    fun start()
    fun stop()
}