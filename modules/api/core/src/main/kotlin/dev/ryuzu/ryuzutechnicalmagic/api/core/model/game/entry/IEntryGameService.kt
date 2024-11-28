package dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.entry

import dev.ryuzu.ryuzutechnicalmagic.api.core.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagic.api.core.model.game.mode.GameMode

interface IEntryGameService {
    val location: ConfiguredIntLocation
    val entryPlayers: MutableSet<dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer>
    var gameMode: GameMode
    var stageId: String?
    var isStart: Boolean

    fun getMinimumPlayer(): Int
    fun getMaximumPlayer(): Int
    fun isEntryPlayer(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer): Boolean
    fun getEntryPlayerNumber(): Int
    fun entry(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
    fun leave(player: dev.ryuzu.ryuzutechnicalmagic.api.core.model.entity.IPlayer)
}