package dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.general

data class ConfiguredGeneralParameter(
    val playerPin: ConfiguredPlayerPin,
    val levelParameter: ConfiguredLevelParameter,
    val generatorParameter: dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.general.ConfiguredGeneratorParameter,
    val damageHistoryParameter: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.general.ConfiguredDamageHistoryParameter,
    val respawnParameter: ConfiguredRespawnParameter,
    val autoSavingParameter: dev.ryuzu.ryuzutechnicalmagic.api.core.configuration.general.ConfiguredAutoSavingParameter,
)
