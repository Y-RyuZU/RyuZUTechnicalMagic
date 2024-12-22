package dev.ryuzu.ryuzutechnicalmagic.api.game.service.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.data.base.SerIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagic.api.game.service.mode.GameMode

interface IEntryGameService {
    val location: SerIntLocation
    val entryPlayers: MutableSet<IPlayer>
    var gameMode: GameMode
    var stageId: String?
    var isStart: Boolean

    fun getMinimumPlayer(): Int
    fun getMaximumPlayer(): Int
    fun isEntryPlayer(player: IPlayer): Boolean
    fun getEntryPlayerNumber(): Int
    fun entry(player: IPlayer)
    fun leave(player: IPlayer)
}