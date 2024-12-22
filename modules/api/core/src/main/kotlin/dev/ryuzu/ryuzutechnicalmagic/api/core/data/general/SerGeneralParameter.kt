package dev.ryuzu.ryuzutechnicalmagic.api.core.data.general

data class SerGeneralParameter(
    val playerPin: SerPlayerPin,
    val levelParameter: SerLevelParameter,
    val generatorParameter: SerGeneratorParameter,
    val damageHistoryParameter: SerDamageHistoryParameter,
    val respawnParameter: SerRespawnParameter,
    val autoSavingParameter: SerAutoSavingParameter,
)
