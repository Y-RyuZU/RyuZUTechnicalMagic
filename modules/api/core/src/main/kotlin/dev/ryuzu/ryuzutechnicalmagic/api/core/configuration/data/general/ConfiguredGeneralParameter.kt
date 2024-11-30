package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.data.general

data class ConfiguredGeneralParameter(
    val playerPin: ConfiguredPlayerPin,
    val levelParameter: ConfiguredLevelParameter,
    val generatorParameter: ConfiguredGeneratorParameter,
    val damageHistoryParameter: ConfiguredDamageHistoryParameter,
    val respawnParameter: ConfiguredRespawnParameter,
    val autoSavingParameter: ConfiguredAutoSavingParameter,
)
