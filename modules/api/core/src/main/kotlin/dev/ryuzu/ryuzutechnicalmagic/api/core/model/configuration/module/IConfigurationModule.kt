package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.module

interface IConfigurationModule<ResultValue, ValuePerFile> {
    fun loadConfig(): ResultValue
}