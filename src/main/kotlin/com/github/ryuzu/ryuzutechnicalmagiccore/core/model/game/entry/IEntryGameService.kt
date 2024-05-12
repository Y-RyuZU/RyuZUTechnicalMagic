package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.entry

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.configuration.base.ConfiguredIntLocation
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode.GameMode
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.entity.IPlayer
import org.koin.core.component.KoinComponent

interface IEntryGameService : KoinComponent {
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