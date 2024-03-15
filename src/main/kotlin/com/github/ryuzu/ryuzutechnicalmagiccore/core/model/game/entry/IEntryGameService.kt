package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import java.util.*

interface IEntryGameService {
    val entryPlayers: MutableSet<UUID>
    var gameMode: GameMode
    var isStart: Boolean

    fun entry(player: UUID)
    fun leave(player: UUID)
}