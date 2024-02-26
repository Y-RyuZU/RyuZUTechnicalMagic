package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.event

data class Freeze(override val probability: Int, val duration: Int): IEvent
