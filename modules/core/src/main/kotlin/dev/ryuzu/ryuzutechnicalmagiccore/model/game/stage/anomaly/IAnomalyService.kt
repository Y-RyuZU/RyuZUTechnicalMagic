package dev.ryuzu.ryuzutechnicalmagiccore.model.game.stage.anomaly

interface IAnomalyService {
    fun init()
    fun tick()
    fun close()
}