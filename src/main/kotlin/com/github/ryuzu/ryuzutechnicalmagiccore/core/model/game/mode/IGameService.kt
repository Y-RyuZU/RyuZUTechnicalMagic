package com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.mode

import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.game.player.IGamePlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.player.IPlayer
import com.github.ryuzu.ryuzutechnicalmagiccore.core.model.skill.param.ISkillEventPrams.ICasterEventParams.CasterEventParams.IDamageEventParams
import org.koin.core.component.KoinComponent
import java.util.UUID

interface IGameService {
    val world: String

    fun start()
    fun end()
    fun onPlayerDeath(eventParams: IDamageEventParams)
    fun joinGameMidway(player: IPlayer)
    fun leaveGame(player: IPlayer)
    fun getPhase(): Int
    fun getGamePlayer(player: IPlayer): IGamePlayer
    fun isGamePlayer(player: IPlayer): Boolean
}