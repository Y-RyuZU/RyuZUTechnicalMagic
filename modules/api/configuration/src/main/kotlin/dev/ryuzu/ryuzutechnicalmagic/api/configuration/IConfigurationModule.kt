package dev.ryuzu.ryuzutechnicalmagic.api.configuration

interface IConfigurationModule<ResultValue, ValuePerFile> {
    fun loadConfig(): ResultValue
}