package dev.ryuzu.ryuzutechnicalmagicapi.model.game.entry

import dev.ryuzu.ryuzutechnicalmagicapi.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagicapi.model.game.mode.GameMode
import dev.ryuzu.ryuzutechnicalmagicapi.model.entity.IPlayer

interface IEntryGameService {
    val location: ConfiguredIntLocation
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