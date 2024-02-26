package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.player

data class CarryTNTPlayer(
    override val team: String,
    override val star: Int,
    override val kill: Int,
    override val death: Int,
    override val assist: Int
): IGamePlayer