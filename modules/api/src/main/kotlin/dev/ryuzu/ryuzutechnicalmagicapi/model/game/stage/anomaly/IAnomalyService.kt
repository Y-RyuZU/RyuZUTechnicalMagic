package dev.ryuzu.ryuzutechnicalmagicapi.model.game.stage.anomaly

interface IAnomalyService {
    fun init()
    fun tick()
    fun close()
}