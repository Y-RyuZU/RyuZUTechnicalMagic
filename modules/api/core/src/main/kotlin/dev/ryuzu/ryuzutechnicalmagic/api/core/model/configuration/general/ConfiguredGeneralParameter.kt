package dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general

data class ConfiguredGeneralParameter(
    val playerPin: ConfiguredPlayerPin,
    val levelParameter: ConfiguredLevelParameter,
    val generatorParameter: dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneratorParameter,
    val damageHistoryParameter: ConfiguredDamageHistoryParameter,
    val respawnParameter: ConfiguredRespawnParameter,
    val autoSavingParameter: ConfiguredAutoSavingParameter,
)
