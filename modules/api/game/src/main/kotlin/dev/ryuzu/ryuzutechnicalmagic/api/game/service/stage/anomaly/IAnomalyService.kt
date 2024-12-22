package dev.ryuzu.ryuzutechnicalmagic.api.game.service.stage.anomaly

interface IAnomalyService {
    fun init()
    fun tick()
    fun close()
}