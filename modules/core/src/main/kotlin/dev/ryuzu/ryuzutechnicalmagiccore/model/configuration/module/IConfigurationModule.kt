package dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.module

import org.koin.core.component.KoinComponent

interface IConfigurationModule<ResultValue, ValuePerFile> : KoinComponent {
    fun loadConfig(): ResultValue
}