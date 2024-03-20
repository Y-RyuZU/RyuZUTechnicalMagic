package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import org.koin.core.component.KoinComponent
import java.util.*

interface IEntryGameService : KoinComponent {
    var gameMode: GameMode
    var isStart: Boolean

    fun getMinimumPlayer(): Int
    fun getMaximumPlayer(): Int
    fun isEntryPlayer(player: UUID): Boolean
    fun getEntryPlayerNumber(): Int
    fun entry(player: UUID)
    fun leave(player: UUID)
}