package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.module

interface IConfigurationModule<ResultValue, ValuePerFile> {
    fun loadConfig(): ResultValue
}