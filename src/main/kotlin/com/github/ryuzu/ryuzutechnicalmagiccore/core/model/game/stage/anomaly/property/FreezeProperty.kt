package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.stage.anomaly.property

data class FreezeProperty(override val probability: Int, val duration: Int): IAnomalyProperty
