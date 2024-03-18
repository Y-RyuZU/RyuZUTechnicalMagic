package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.game.anomaly

data class FreezeProperty(override val probability: Int, val duration: Int): IAnomalyProperty
