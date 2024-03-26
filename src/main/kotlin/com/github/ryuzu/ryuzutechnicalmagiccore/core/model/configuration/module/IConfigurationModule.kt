package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.module

import org.koin.core.component.KoinComponent

interface IConfigurationModule<T, U> : KoinComponent {
    fun loadConfig(): T
}