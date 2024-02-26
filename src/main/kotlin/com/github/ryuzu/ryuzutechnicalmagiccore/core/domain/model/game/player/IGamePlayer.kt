package com.github.ryuzu.ryuzutechnicalmagiccore.core.domain.model.game.player

interface IGamePlayer {
    val team: String
    val star: Int
    val kill: Int
    val death: Int
    val assist: Int
}