package dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.module

interface IConfigurationModule<ResultValue, ValuePerFile> {
    fun loadConfig(): ResultValue
}