package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.event

data class Meteo(override val probability: Int, val radius: Double): IEvent
