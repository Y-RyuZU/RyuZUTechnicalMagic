package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.stage.anomaly

interface IAnomalyService {
    fun init()
    fun tick()
    fun close()
}