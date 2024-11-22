package dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.carrytnt

import dev.ryuzu.ryuzutechnicalmagiccore.model.configuration.base.ConfiguredIntLocation
import dev.ryuzu.ryuzutechnicalmagiccore.model.entity.IPlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.mode.ITeamGameService
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer
import dev.ryuzu.ryuzutechnicalmagiccore.model.game.player.IGamePlayer.GamePlayer.ITeamGamePlayer.TeamGamePlayer.ICarryTntPlayer

interface ICarryTntService : ITeamGameService {
    override fun getGamePlayer(player: IPlayer): ICarryTntPlayer
    fun tryCarryTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun lostTNT(player: ICarryTntPlayer)
    fun placeTnt(location: ConfiguredIntLocation, player: ICarryTntPlayer)
    fun isHoldPlayer(player: ICarryTntPlayer): Boolean
    fun isTargetTNTPoint(location: ConfiguredIntLocation, player: ICarryTntPlayer): Boolean
    fun isTntItemId(itemId: String): Boolean
}